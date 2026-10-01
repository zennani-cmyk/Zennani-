package com.example.data.repository

import com.example.data.local.ChannelDao
import com.example.data.local.CustomChannelEntity
import com.example.data.local.FavoriteChannelEntity
import com.example.data.local.WatchHistoryEntity
import com.example.data.model.Channel
import com.example.data.model.ChannelCategory
import com.example.data.model.ProgramSchedule
import com.example.data.sample.ChannelsCatalog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

class ChannelRepository(private val channelDao: ChannelDao) {

    val favoriteIds: Flow<List<String>> = channelDao.getFavoriteChannelIds()

    val watchHistory: Flow<List<WatchHistoryEntity>> = channelDao.getWatchHistory()

    val allChannels: Flow<List<Channel>> = channelDao.getAllCustomChannels().map { customEntities ->
        val customChannels = customEntities.map { entity ->
            val cat = try {
                ChannelCategory.valueOf(entity.category)
            } catch (e: Exception) {
                ChannelCategory.CUSTOM
            }
            Channel(
                id = entity.id,
                nameArabic = entity.nameArabic,
                nameEnglish = entity.nameEnglish,
                category = cat,
                country = entity.country.ifBlank { "مخصص" },
                countryCode = "TV",
                streamUrl = entity.streamUrl,
                logoUrl = entity.logoUrl.ifBlank {
                    "https://images.unsplash.com/photo-1593784991095-a205069470b6?w=200&auto=format&fit=crop&q=80"
                },
                currentShow = "بث مخصص للمستخدم",
                resolution = entity.resolution,
                isFeatured = false,
                isCustom = true
            )
        }
        ChannelsCatalog.initialChannels + customChannels
    }

    suspend fun toggleFavorite(channelId: String, isCurrentlyFavorite: Boolean) {
        if (isCurrentlyFavorite) {
            channelDao.deleteFavorite(channelId)
        } else {
            channelDao.insertFavorite(FavoriteChannelEntity(channelId = channelId))
        }
    }

    suspend fun addCustomChannel(
        nameArabic: String,
        nameEnglish: String,
        streamUrl: String,
        category: ChannelCategory,
        country: String,
        logoUrl: String
    ) {
        val customId = "custom_${System.currentTimeMillis()}"
        val entity = CustomChannelEntity(
            id = customId,
            nameArabic = nameArabic,
            nameEnglish = nameEnglish.ifBlank { nameArabic },
            category = category.name,
            country = country.ifBlank { "مخصص" },
            streamUrl = streamUrl,
            logoUrl = logoUrl,
            resolution = "HD"
        )
        channelDao.insertCustomChannel(entity)
    }

    suspend fun deleteCustomChannel(id: String) {
        channelDao.deleteCustomChannel(id)
        channelDao.deleteFavorite(id)
    }

    suspend fun recordWatchHistory(channel: Channel) {
        val historyItem = WatchHistoryEntity(
            channelId = channel.id,
            channelName = channel.nameArabic,
            category = channel.category.titleArabic,
            streamUrl = channel.streamUrl,
            logoUrl = channel.logoUrl,
            lastWatchedAt = System.currentTimeMillis()
        )
        channelDao.insertWatchHistory(historyItem)
    }

    suspend fun clearHistory() {
        channelDao.clearWatchHistory()
    }

    fun getSchedulesForChannel(channelId: String): List<ProgramSchedule> {
        val specific = ChannelsCatalog.sampleSchedules.filter { it.channelId == channelId }
        if (specific.isNotEmpty()) return specific

        // Generates realistic schedule when channel doesn't have explicit mock schedule
        return listOf(
            ProgramSchedule(
                channelId = channelId,
                time = "الآن",
                title = "البث المباشر المستمر",
                description = "نقل حي متواصل على مدار الساعة بجودة عالية",
                isLiveNow = true
            ),
            ProgramSchedule(
                channelId = channelId,
                time = "15:00",
                title = "نشرة الأخبار والتقارير",
                description = "موجز لأهم التطورات والأخبار المحلية والعالمية",
                isLiveNow = false
            ),
            ProgramSchedule(
                channelId = channelId,
                time = "17:30",
                title = "برنامج حواري مسائي",
                description = "استضافة نخبة من المحللين والمختصين لمناقشة قضايا الساعة",
                isLiveNow = false
            ),
            ProgramSchedule(
                channelId = channelId,
                time = "21:00",
                title = "السهرة المسائية الخاصة",
                description = "برامج مميزة وتغطيات حصرية للجمهور",
                isLiveNow = false
            )
        )
    }
}
