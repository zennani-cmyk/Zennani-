package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_channels")
data class FavoriteChannelEntity(
    @PrimaryKey val channelId: String,
    val addedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "custom_channels")
data class CustomChannelEntity(
    @PrimaryKey val id: String,
    val nameArabic: String,
    val nameEnglish: String,
    val category: String,
    val country: String,
    val streamUrl: String,
    val logoUrl: String,
    val resolution: String = "HD",
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "watch_history")
data class WatchHistoryEntity(
    @PrimaryKey val channelId: String,
    val channelName: String,
    val category: String,
    val streamUrl: String,
    val logoUrl: String,
    val lastWatchedAt: Long = System.currentTimeMillis()
)
