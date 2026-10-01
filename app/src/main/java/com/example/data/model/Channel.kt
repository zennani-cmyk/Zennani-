package com.example.data.model

enum class ChannelCategory(
    val titleArabic: String,
    val iconName: String
) {
    ALL("الكل", "All"),
    NEWS("أخبار", "News"),
    ISLAMIC("دين وقرآن", "Islamic"),
    SPORTS("رياضة", "Sports"),
    ENTERTAINMENT("ترفيه", "Entertainment"),
    KIDS("أطفال", "Kids"),
    DOCUMENTARY("وثائقي", "Docs"),
    INTERNATIONAL("عالمية", "World"),
    CUSTOM("قنواتي الخاصة", "Custom")
}

data class Channel(
    val id: String,
    val nameArabic: String,
    val nameEnglish: String,
    val category: ChannelCategory,
    val country: String,
    val countryCode: String,
    val streamUrl: String,
    val backupStreamUrl: String? = null,
    val logoUrl: String,
    val currentShow: String,
    val nextShow: String? = null,
    val resolution: String = "1080p FHD",
    val isFeatured: Boolean = false,
    val isCustom: Boolean = false
)

data class ProgramSchedule(
    val channelId: String,
    val time: String,
    val title: String,
    val description: String,
    val isLiveNow: Boolean = false
)
