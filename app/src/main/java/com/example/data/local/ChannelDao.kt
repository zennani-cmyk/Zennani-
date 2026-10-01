package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ChannelDao {

    // Favorites
    @Query("SELECT channelId FROM favorite_channels ORDER BY addedAt DESC")
    fun getFavoriteChannelIds(): Flow<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: FavoriteChannelEntity)

    @Query("DELETE FROM favorite_channels WHERE channelId = :channelId")
    suspend fun deleteFavorite(channelId: String)

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_channels WHERE channelId = :channelId)")
    fun isFavorite(channelId: String): Flow<Boolean>

    // Custom Channels
    @Query("SELECT * FROM custom_channels ORDER BY createdAt DESC")
    fun getAllCustomChannels(): Flow<List<CustomChannelEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomChannel(channel: CustomChannelEntity)

    @Query("DELETE FROM custom_channels WHERE id = :id")
    suspend fun deleteCustomChannel(id: String)

    // Watch History
    @Query("SELECT * FROM watch_history ORDER BY lastWatchedAt DESC LIMIT 20")
    fun getWatchHistory(): Flow<List<WatchHistoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWatchHistory(item: WatchHistoryEntity)

    @Query("DELETE FROM watch_history")
    suspend fun clearWatchHistory()
}
