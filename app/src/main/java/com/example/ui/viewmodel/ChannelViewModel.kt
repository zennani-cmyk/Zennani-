package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.WatchHistoryEntity
import com.example.data.model.Channel
import com.example.data.model.ChannelCategory
import com.example.data.model.ProgramSchedule
import com.example.data.repository.ChannelRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ChannelViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ChannelRepository

    init {
        val db = AppDatabase.getDatabase(application)
        repository = ChannelRepository(db.channelDao())
    }

    val allChannels: StateFlow<List<Channel>> = repository.allChannels.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val favoriteIds: StateFlow<Set<String>> = repository.favoriteIds
        .combine(MutableStateFlow(Unit)) { list, _ -> list.toSet() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptySet()
        )

    val watchHistory: StateFlow<List<WatchHistoryEntity>> = repository.watchHistory.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    private val _selectedCategory = MutableStateFlow(ChannelCategory.ALL)
    val selectedCategory: StateFlow<ChannelCategory> = _selectedCategory.asStateFlow()

    private val _selectedCountry = MutableStateFlow<String?>(null)
    val selectedCountry: StateFlow<String?> = _selectedCountry.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _activePlayingChannel = MutableStateFlow<Channel?>(null)
    val activePlayingChannel: StateFlow<Channel?> = _activePlayingChannel.asStateFlow()

    // Filtered channels combining search, category, and country
    val filteredChannels: StateFlow<List<Channel>> = combine(
        allChannels,
        _selectedCategory,
        _selectedCountry,
        _searchQuery
    ) { channels, category, country, query ->
        channels.filter { channel ->
            val matchesCategory = when (category) {
                ChannelCategory.ALL -> true
                ChannelCategory.CUSTOM -> channel.isCustom
                else -> channel.category == category
            }
            val matchesCountry = country == null || channel.country.contains(country, ignoreCase = true)
            val matchesQuery = query.isBlank() ||
                    channel.nameArabic.contains(query, ignoreCase = true) ||
                    channel.nameEnglish.contains(query, ignoreCase = true) ||
                    channel.country.contains(query, ignoreCase = true) ||
                    channel.currentShow.contains(query, ignoreCase = true)

            matchesCategory && matchesCountry && matchesQuery
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    // Favorite channels list
    val favoriteChannels: StateFlow<List<Channel>> = combine(
        allChannels,
        favoriteIds
    ) { channels, favIds ->
        channels.filter { favIds.contains(it.id) }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun setCategory(category: ChannelCategory) {
        _selectedCategory.value = category
    }

    fun setCountry(country: String?) {
        _selectedCountry.value = country
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectChannel(channel: Channel) {
        _activePlayingChannel.value = channel
        viewModelScope.launch {
            repository.recordWatchHistory(channel)
        }
    }

    fun closePlayer() {
        _activePlayingChannel.value = null
    }

    fun nextChannel() {
        val current = _activePlayingChannel.value ?: return
        val list = filteredChannels.value.ifEmpty { allChannels.value }
        val currentIndex = list.indexOfFirst { it.id == current.id }
        if (currentIndex != -1 && list.isNotEmpty()) {
            val nextIndex = (currentIndex + 1) % list.size
            selectChannel(list[nextIndex])
        }
    }

    fun previousChannel() {
        val current = _activePlayingChannel.value ?: return
        val list = filteredChannels.value.ifEmpty { allChannels.value }
        val currentIndex = list.indexOfFirst { it.id == current.id }
        if (currentIndex != -1 && list.isNotEmpty()) {
            val prevIndex = if (currentIndex - 1 < 0) list.size - 1 else currentIndex - 1
            selectChannel(list[prevIndex])
        }
    }

    fun toggleFavorite(channel: Channel) {
        viewModelScope.launch {
            val isFav = favoriteIds.value.contains(channel.id)
            repository.toggleFavorite(channel.id, isFav)
        }
    }

    fun addCustomChannel(
        nameArabic: String,
        nameEnglish: String,
        streamUrl: String,
        category: ChannelCategory,
        country: String,
        logoUrl: String
    ) {
        viewModelScope.launch {
            repository.addCustomChannel(
                nameArabic = nameArabic,
                nameEnglish = nameEnglish,
                streamUrl = streamUrl,
                category = category,
                country = country,
                logoUrl = logoUrl
            )
        }
    }

    fun deleteCustomChannel(id: String) {
        viewModelScope.launch {
            repository.deleteCustomChannel(id)
            if (_activePlayingChannel.value?.id == id) {
                _activePlayingChannel.value = null
            }
        }
    }

    fun clearHistory() {
        viewModelScope.launch {
            repository.clearHistory()
        }
    }

    fun getSchedules(channelId: String): List<ProgramSchedule> {
        return repository.getSchedulesForChannel(channelId)
    }
}
