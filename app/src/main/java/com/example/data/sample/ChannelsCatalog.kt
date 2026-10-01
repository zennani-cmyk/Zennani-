package com.example.data.sample

import com.example.data.model.Channel
import com.example.data.model.ChannelCategory
import com.example.data.model.ProgramSchedule

object ChannelsCatalog {

    val initialChannels: List<Channel> = listOf(
        // 1. الدين والقرآن (Holy Mosques & Islamic)
        Channel(
            id = "saudi_quran",
            nameArabic = "قناة القرآن الكريم",
            nameEnglish = "Saudi Quran (Makkah Live)",
            category = ChannelCategory.ISLAMIC,
            country = "السعودية",
            countryCode = "SA",
            streamUrl = "https://live.al-eman.tv/hls/quran.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            logoUrl = "https://images.unsplash.com/photo-1542816417-0983c9c9ad53?w=200&auto=format&fit=crop&q=80",
            currentShow = "بث حي ومباشر من المسجد الحرام بمكة المكرمة",
            nextShow = "تلاوات خاشعة لآيات الذكر الحكيم",
            resolution = "1080p FHD",
            isFeatured = true
        ),
        Channel(
            id = "saudi_sunnah",
            nameArabic = "قناة السنة النبوية",
            nameEnglish = "Saudi Sunnah (Madinah Live)",
            category = ChannelCategory.ISLAMIC,
            country = "السعودية",
            countryCode = "SA",
            streamUrl = "https://live.al-eman.tv/hls/sunnah.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            logoUrl = "https://images.unsplash.com/photo-1591604129939-f1efa4d9f7fa?w=200&auto=format&fit=crop&q=80",
            currentShow = "بث حي من المسجد النبوي الشريف بالمدينة المنورة",
            nextShow = "أحاديث نبوية شريفة وسيرة عطرة",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "almajd_quran",
            nameArabic = "قناة المجد للقرآن الكريم",
            nameEnglish = "Almajd Holy Quran",
            category = ChannelCategory.ISLAMIC,
            country = "السعودية",
            countryCode = "SA",
            streamUrl = "https://streaming.al-eman.tv/hls/almajd.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            logoUrl = "https://images.unsplash.com/photo-1609599006353-e629aaabfeae?w=200&auto=format&fit=crop&q=80",
            currentShow = "ختمة قرآنية مباركة بأصوات كبار القراء",
            nextShow = "تفسير ميسر لكلمات القرآن",
            resolution = "720p HD",
            isFeatured = false
        ),

        // 2. الأخبار (News)
        Channel(
            id = "aljazeera_news",
            nameArabic = "الجزيرة الإخبارية",
            nameEnglish = "Al Jazeera Arabic",
            category = ChannelCategory.NEWS,
            country = "قطر",
            countryCode = "QA",
            streamUrl = "https://live-hls-web-aja.getaj.net/AJA/01.m3u8",
            backupStreamUrl = "https://devstreaming-cdn.apple.com/videos/streaming/examples/bipbop_4x3/bipbop_4x3_variant.m3u8",
            logoUrl = "https://images.unsplash.com/photo-1585829365295-ab7cd400c167?w=200&auto=format&fit=crop&q=80",
            currentShow = "نشرة الحصاد الإخباري والتغطيات الحية",
            nextShow = "ما وراء الخبر والتحليل السياسي",
            resolution = "1080p FHD",
            isFeatured = true
        ),
        Channel(
            id = "aljazeera_mubasher",
            nameArabic = "الجزيرة مباشر",
            nameEnglish = "Al Jazeera Mubasher",
            category = ChannelCategory.NEWS,
            country = "قطر",
            countryCode = "QA",
            streamUrl = "https://live-hls-web-ajm.getaj.net/AJM/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
            logoUrl = "https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=200&auto=format&fit=crop&q=80",
            currentShow = "تغطيات ميدانية ومؤتمرات صحفية على الهواء",
            nextShow = "نافذة مباشرة مع المراسلين",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "alaraby_tv",
            nameArabic = "التلفزيون العربي",
            nameEnglish = "Al Araby TV",
            category = ChannelCategory.NEWS,
            country = "بريطانيا / قطر",
            countryCode = "QA",
            streamUrl = "https://alaraby.connected-stories.com/alaraby/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
            logoUrl = "https://images.unsplash.com/photo-1495020689067-958852a7765e?w=200&auto=format&fit=crop&q=80",
            currentShow = "العربي اليوم - قراءة معمقة للأحداث",
            nextShow = "تقدير موقف",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "france24_ar",
            nameArabic = "فرنسا 24 عربي",
            nameEnglish = "France 24 Arabic",
            category = ChannelCategory.NEWS,
            country = "فرنسا",
            countryCode = "FR",
            streamUrl = "https://f24hls-i.akamaihd.net/hls/live/221193/F24_AR_HLS_PAN/master.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
            logoUrl = "https://images.unsplash.com/photo-1526470608268-f674ce90ebd4?w=200&auto=format&fit=crop&q=80",
            currentShow = "باريس توك ونشرة أنباء العالم",
            nextShow = "حوار الأسبوع مع الشخصيات الفاعلة",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "dw_arabic",
            nameArabic = "DW عربية",
            nameEnglish = "Deutsche Welle Arabic",
            category = ChannelCategory.NEWS,
            country = "ألمانيا",
            countryCode = "DE",
            streamUrl = "https://dwamdstream104.akamaized.net/hls/live/2015530/dwstream104/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
            logoUrl = "https://images.unsplash.com/photo-1518770660439-4636190af475?w=200&auto=format&fit=crop&q=80",
            currentShow = "مسائية DW وتغطية الملفات الإقليمية",
            nextShow = "شباب توك وبرامج الحوار",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "trt_arabi",
            nameArabic = "TRT عربي",
            nameEnglish = "TRT Arabi",
            category = ChannelCategory.NEWS,
            country = "تركيا",
            countryCode = "TR",
            streamUrl = "https://tv-trtarabi.medya.trt.com.tr/master.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyBlazes.mp4",
            logoUrl = "https://images.unsplash.com/photo-1557804506-669a67965ba0?w=200&auto=format&fit=crop&q=80",
            currentShow = "العالم هذا المساء وتقارير المراسلين",
            nextShow = "قصة اليوم - وثائقي تركي",
            resolution = "720p HD",
            isFeatured = false
        ),

        // 3. الرياضة (Sports)
        Channel(
            id = "arryadia_maroc",
            nameArabic = "الرياضية المغربية (Arryadia)",
            nameEnglish = "Arryadia TNT Morocco",
            category = ChannelCategory.SPORTS,
            country = "المغرب",
            countryCode = "MA",
            streamUrl = "https://cdnamd-hls-globecast.akamaized.net/live/ramdisk/arryadia/hls_snrt/arryadia.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
            logoUrl = "https://images.unsplash.com/photo-1508098682722-e99c43a406b2?w=200&auto=format&fit=crop&q=80",
            currentShow = "استوديو البطولة الاحترافية المغربية ومباريات حية",
            nextShow = "حصاد الملاعب وتحليل الجولة",
            resolution = "1080p FHD",
            isFeatured = true
        ),
        Channel(
            id = "dubai_sports",
            nameArabic = "دبي الرياضية",
            nameEnglish = "Dubai Sports",
            category = ChannelCategory.SPORTS,
            country = "الإمارات",
            countryCode = "AE",
            streamUrl = "https://dmi.mangomolo.com/dubaisports/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
            logoUrl = "https://images.unsplash.com/photo-1461896836934-ffe607ba8211?w=200&auto=format&fit=crop&q=80",
            currentShow = "تغطيات سباقات الخليج ومباريات كرة القدم",
            nextShow = "المنصة - تحليل رياضي شامل",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "ad_sports_1",
            nameArabic = "أبوظبي الرياضية 1",
            nameEnglish = "Abu Dhabi Sports 1",
            category = ChannelCategory.SPORTS,
            country = "الإمارات",
            countryCode = "AE",
            streamUrl = "https://admdn1.cdn.mangomolo.com/adsports1/smil:adsports1.smil/playlist.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackSeeTheWorld.mp4",
            logoUrl = "https://images.unsplash.com/photo-1574629810360-7efbbe195018?w=200&auto=format&fit=crop&q=80",
            currentShow = "دوري أدنوك للمحترفين وبطولات الجوجيتسو",
            nextShow = "برنامج جيم أوفر",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "alkass_sports",
            nameArabic = "قنوات الكأس الرياضية",
            nameEnglish = "Alkass Sports News",
            category = ChannelCategory.SPORTS,
            country = "قطر",
            countryCode = "QA",
            streamUrl = "https://shoof.alkass.net/alkass/live/channel_one.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4",
            logoUrl = "https://images.unsplash.com/photo-1517649763962-0c623266ddc0?w=200&auto=format&fit=crop&q=80",
            currentShow = "برنامج المجلس مع خالد جاسم",
            nextShow = "نشرة أخبار الكأس الدولية",
            resolution = "1080p FHD",
            isFeatured = false
        ),

        // 4. الترفيه والقنوات الوطنية (General & National)
        Channel(
            id = "egypt_channel_1",
            nameArabic = "القناة الأولى المصرية",
            nameEnglish = "Egyptian TV 1",
            category = ChannelCategory.ENTERTAINMENT,
            country = "مصر",
            countryCode = "EG",
            streamUrl = "https://masertv.mangomolo.com/ch1/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            logoUrl = "https://images.unsplash.com/photo-1539650116574-8efeb43e2750?w=200&auto=format&fit=crop&q=80",
            currentShow = "صباح الخير يا مصر وبث مباشر للمحافظات",
            nextShow = "مسلسلات درامية وأفلام عربية كلاسيكية",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "alaoula_maroc",
            nameArabic = "الأولى المغربية (SNRT 1)",
            nameEnglish = "Al Aoula Morocco",
            category = ChannelCategory.ENTERTAINMENT,
            country = "المغرب",
            countryCode = "MA",
            streamUrl = "https://cdnamd-hls-globecast.akamaized.net/live/ramdisk/al_aoula_inter/hls_snrt/al_aoula_inter.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            logoUrl = "https://images.unsplash.com/photo-1548013146-72479768bada?w=200&auto=format&fit=crop&q=80",
            currentShow = "برامج تلفزيونية وثقافية ومسلسلات مغربية",
            nextShow = "نشرة الأخبار الرئيسية المسائية",
            resolution = "720p HD",
            isFeatured = false
        ),
        Channel(
            id = "wataniya_1_tunis",
            nameArabic = "الوطنية 1 التونسية",
            nameEnglish = "El Wataniya 1 Tunisia",
            category = ChannelCategory.ENTERTAINMENT,
            country = "تونس",
            countryCode = "TN",
            streamUrl = "https://streaming.watania.tn/live/watania1.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
            logoUrl = "https://images.unsplash.com/photo-1516483638261-f4dbaf036963?w=200&auto=format&fit=crop&q=80",
            currentShow = "تونس اليوم وبرامج الفن والدراما",
            nextShow = "الأنباء والمنوعات التونسية",
            resolution = "720p HD",
            isFeatured = false
        ),
        Channel(
            id = "dubai_tv",
            nameArabic = "تلفزيون دبي",
            nameEnglish = "Dubai TV",
            category = ChannelCategory.ENTERTAINMENT,
            country = "الإمارات",
            countryCode = "AE",
            streamUrl = "https://dmi.mangomolo.com/dubaitv/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            logoUrl = "https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=200&auto=format&fit=crop&q=80",
            currentShow = "ذا إنسايدر بالعربي وأحدث عروض الدراما",
            nextShow = "برنامج دبي هذا الصباح",
            resolution = "1080p FHD",
            isFeatured = false
        ),

        // 5. الأطفال والكرتون (Kids)
        Channel(
            id = "spacetoon_live",
            nameArabic = "سبيستون (قناة شباب المستقبل)",
            nameEnglish = "Spacetoon TV",
            category = ChannelCategory.KIDS,
            country = "عالمية / سوريا",
            countryCode = "SY",
            streamUrl = "https://stream.spacetoon.com/live/ch1/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            logoUrl = "https://images.unsplash.com/photo-1563089145-599997674d42?w=200&auto=format&fit=crop&q=80",
            currentShow = "كوكب مغامرات وأروع مسلسلات الرسوم المتحركة",
            nextShow = "كوكب أكشن وأفلام الأنمي المدبلجة",
            resolution = "1080p FHD",
            isFeatured = true
        ),
        Channel(
            id = "majid_kids",
            nameArabic = "قناة ماجد للأطفال",
            nameEnglish = "Majid Kids",
            category = ChannelCategory.KIDS,
            country = "الإمارات",
            countryCode = "AE",
            streamUrl = "https://admdn1.cdn.mangomolo.com/majid/smil:majid.smil/playlist.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            logoUrl = "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=200&auto=format&fit=crop&q=80",
            currentShow = "مغامرات ماجد وكسلان وفطين",
            nextShow = "أناشيد وبرامج تعليمية ترفيهية للأطفال",
            resolution = "720p HD",
            isFeatured = false
        ),

        // 6. الوثائقيات والمعرفة (Documentary)
        Channel(
            id = "aljazeera_doc",
            nameArabic = "الجزيرة الوثائقية",
            nameEnglish = "Al Jazeera Documentary",
            category = ChannelCategory.DOCUMENTARY,
            country = "قطر",
            countryCode = "QA",
            streamUrl = "https://live-hls-web-ajd.getaj.net/AJD/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
            logoUrl = "https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=200&auto=format&fit=crop&q=80",
            currentShow = "أفلام استقصائية وتاريخية وثقافية حائزة على جوائز",
            nextShow = "أسرار الطبيعة وعجائب الحضارات",
            resolution = "1080p FHD",
            isFeatured = true
        ),
        Channel(
            id = "natgeo_ad",
            nameArabic = "ناشيونال جيوغرافيك أبوظبي",
            nameEnglish = "National Geographic Abu Dhabi",
            category = ChannelCategory.DOCUMENTARY,
            country = "الإمارات",
            countryCode = "AE",
            streamUrl = "https://admdn1.cdn.mangomolo.com/adsports1/smil:adsports1.smil/playlist.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
            logoUrl = "https://images.unsplash.com/photo-1534188753412-3e26d0d618d6?w=200&auto=format&fit=crop&q=80",
            currentShow = "عالم الحيوانات المفترسة وسموم الأفاعي القاتلة",
            nextShow = "هياكل عملاقة وتحقيقات الكوارث الجوية",
            resolution = "1080p FHD",
            isFeatured = true
        ),
        Channel(
            id = "alaraby_2_doc",
            nameArabic = "العربي 2 وثائقي وثقافة",
            nameEnglish = "Al Araby 2 Documentaries",
            category = ChannelCategory.DOCUMENTARY,
            country = "قطر",
            countryCode = "QA",
            streamUrl = "https://alaraby.connected-stories.com/alaraby/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            logoUrl = "https://images.unsplash.com/photo-1478760329108-5c3ed9d495a0?w=200&auto=format&fit=crop&q=80",
            currentShow = "سلسلة وثائقية: ذاكرة المكان وعمارة المدن التاريخية",
            nextShow = "أصوات من الشرق ورحلات في أعماق الصحراء",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "dw_documentary_ar",
            nameArabic = "DW وثائقيات",
            nameEnglish = "DW Documentaries Arabic",
            category = ChannelCategory.DOCUMENTARY,
            country = "ألمانيا",
            countryCode = "DE",
            streamUrl = "https://dwamdstream104.akamaized.net/hls/live/2015530/dwstream104/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
            logoUrl = "https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=200&auto=format&fit=crop&q=80",
            currentShow = "وثائقيات كوكب الأرض والعلوم والتكنولوجيا والمناخ",
            nextShow = "رحلات استكشافية حول العالم وأعماق البحار",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "alwathaeqya_egypt",
            nameArabic = "الوثائقية المصرية (Al Wathaeqya)",
            nameEnglish = "Al Wathaeqya Egypt",
            category = ChannelCategory.DOCUMENTARY,
            country = "مصر",
            countryCode = "EG",
            streamUrl = "https://masertv.mangomolo.com/ch1/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            logoUrl = "https://images.unsplash.com/photo-1509198397868-475647b2a1e5?w=200&auto=format&fit=crop&q=80",
            currentShow = "من أسرار التاريخ والحضارة المصرية القديمة",
            nextShow = "شخصيات غيرت مجرى العالم والسينما التسجيلية",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "rtd_arabic",
            nameArabic = "روسيا اليوم الوثائقية (RTD)",
            nameEnglish = "RT Documentary Arabic",
            category = ChannelCategory.DOCUMENTARY,
            country = "روسيا",
            countryCode = "RU",
            streamUrl = "https://f24hls-i.akamaihd.net/hls/live/221193/F24_AR_HLS_PAN/master.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyBlazes.mp4",
            logoUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=200&auto=format&fit=crop&q=80",
            currentShow = "حياة في الجليد وسيبيريا القاسية والقبائل المعزولة",
            nextShow = "أسرار الفضاء السوفيتي ومحطات القطار العابرة للقارات",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "bbc_earth_ar",
            nameArabic = "وثائقيات كوكب الأرض (BBC Earth)",
            nameEnglish = "BBC Earth & Wild",
            category = ChannelCategory.DOCUMENTARY,
            country = "بريطانيا",
            countryCode = "UK",
            streamUrl = "https://euronews-euronews-world-1-eu.rakuten.wurl.tv/playlist.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            logoUrl = "https://images.unsplash.com/photo-1534567153574-2b12153a87f0?w=200&auto=format&fit=crop&q=80",
            currentShow = "كوكب الأرض المذهل: هجرة الحيوانات وسحر الغابات الاستوائية",
            nextShow = "المحيطات الزرقاء وأعظم الكائنات البحرية عملاقاً",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "nasa_tv_live",
            nameArabic = "قناة ناسا للعلوم والفضاء (NASA TV)",
            nameEnglish = "NASA Space & Science Live",
            category = ChannelCategory.DOCUMENTARY,
            country = "الولايات المتحدة",
            countryCode = "US",
            streamUrl = "https://ntv1.akamaized.net/hls/live/2014075/NASA-NTV1-HLS/master.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
            logoUrl = "https://images.unsplash.com/photo-1446776811953-b23d57bd21aa?w=200&auto=format&fit=crop&q=80",
            currentShow = "بث حي مباشر لمحطة الفضاء الدولية ورحلات رواد الفضاء",
            nextShow = "استكشاف المريخ وصور تلسكوب جيمس ويب للكون السحيق",
            resolution = "1080p FHD",
            isFeatured = true
        ),

        // 7. القنوات العالمية (International World Channels)
        Channel(
            id = "euronews_en",
            nameArabic = "يورونيوز الدولية",
            nameEnglish = "Euronews World (English)",
            category = ChannelCategory.INTERNATIONAL,
            country = "أوروبا",
            countryCode = "EU",
            streamUrl = "https://euronews-euronews-world-1-eu.rakuten.wurl.tv/playlist.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
            logoUrl = "https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=200&auto=format&fit=crop&q=80",
            currentShow = "European News & Global Perspectives 24/7",
            nextShow = "No Comment & World Markets",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "france24_en",
            nameArabic = "فرنسا 24 الإنجليزية",
            nameEnglish = "France 24 English",
            category = ChannelCategory.INTERNATIONAL,
            country = "فرنسا",
            countryCode = "FR",
            streamUrl = "https://f24hls-i.akamaihd.net/hls/live/221193/F24_EN_HLS_PAN/master.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            logoUrl = "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=200&auto=format&fit=crop&q=80",
            currentShow = "Live International Breaking News and In-Depth Reports",
            nextShow = "The Debate & Business Interview",
            resolution = "1080p FHD",
            isFeatured = false
        ),
        Channel(
            id = "aljazeera_english",
            nameArabic = "الجزيرة الإنجليزية",
            nameEnglish = "Al Jazeera English",
            category = ChannelCategory.INTERNATIONAL,
            country = "قطر",
            countryCode = "QA",
            streamUrl = "https://live-hls-web-aje.getaj.net/AJE/index.m3u8",
            backupStreamUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
            logoUrl = "https://images.unsplash.com/photo-1586339949916-3e9457bef6d3?w=200&auto=format&fit=crop&q=80",
            currentShow = "Global News Hour & Inside Story",
            nextShow = "Witness - Global Human Documentaries",
            resolution = "1080p FHD",
            isFeatured = false
        )
    )

    val sampleSchedules: List<ProgramSchedule> = listOf(
        ProgramSchedule(
            channelId = "saudi_quran",
            time = "الآن",
            title = "بث مباشر من المسجد الحرام",
            description = "نقل مباشر للأجواء الإيمانية والصلاة وتلاوة القرآن من الحرم المكي الشريف",
            isLiveNow = true
        ),
        ProgramSchedule(
            channelId = "saudi_quran",
            time = "14:30",
            title = "تلاوات قرآنية منتقاة",
            description = "أجمل التلاوات الخاشعة بأصوات أئمة الحرم المكي",
            isLiveNow = false
        ),
        ProgramSchedule(
            channelId = "saudi_quran",
            time = "16:00",
            title = "صلاة العصر من رحاب الكعبة",
            description = "نقل حي لشعائر صلاة العصر مع جموع المصلين والمعتمرين",
            isLiveNow = false
        ),
        ProgramSchedule(
            channelId = "aljazeera_news",
            time = "الآن",
            title = "الحصاد الإخباري",
            description = "موجز شامل لآخر الأخبار السياسية والاقتصادية والأحداث الميدانية العاجلة",
            isLiveNow = true
        ),
        ProgramSchedule(
            channelId = "aljazeera_news",
            time = "15:00",
            title = "ما وراء الخبر",
            description = "حوار معمق مع الخبراء والمحللين حول أبرز تطورات الساحة العربية والدولية",
            isLiveNow = false
        ),
        ProgramSchedule(
            channelId = "arryadia_maroc",
            time = "الآن",
            title = "البطولة الاحترافية إنوي",
            description = "بث مباشر لمباريات الدوري المغربي الممتاز مع استوديو تحليلي",
            isLiveNow = true
        ),
        ProgramSchedule(
            channelId = "arryadia_maroc",
            time = "16:15",
            title = "صدى الملاعب وتحليل الجولة",
            description = "تسليط الضوء على أهداف الجولة وأبرز اللقطات الرياضية وتصريحات المدربين",
            isLiveNow = false
        ),
        ProgramSchedule(
            channelId = "spacetoon_live",
            time = "الآن",
            title = "كوكب مغامرات: المحقق كونان",
            description = "مغامرات شيقة ومثيرة لحل أعقد القضايا والجرائم الغامضة",
            isLiveNow = true
        ),
        ProgramSchedule(
            channelId = "spacetoon_live",
            time = "15:30",
            title = "كوكب رياضة: أبطال الكرة",
            description = "مباريات حماسية ومهارات خارقة في كرة القدم",
            isLiveNow = false
        ),
        ProgramSchedule(
            channelId = "aljazeera_doc",
            time = "الآن",
            title = "وثائقي: أسرار أعماق المحيط",
            description = "رحلة استكشافية مذهلة في أعماق البحار للتعرف على كائنات فريدة",
            isLiveNow = true
        ),
        ProgramSchedule(
            channelId = "aljazeera_doc",
            time = "16:00",
            title = "عدسة استقصائية: حراس الغابات العذراء",
            description = "تحقيق ميداني يرصد جهود حماية الغابات المهددة بالانقراض",
            isLiveNow = false
        ),
        ProgramSchedule(
            channelId = "natgeo_ad",
            time = "الآن",
            title = "تحقيقات الكوارث الجوية: اللحظات الحرجة",
            description = "إعادة بناء درامية وتحليلات تقنية لأكثر الحوادث غموضاً في تاريخ الطيران",
            isLiveNow = true
        ),
        ProgramSchedule(
            channelId = "natgeo_ad",
            time = "17:15",
            title = "وحوش إفريقيا المفترسة: صراع البقاء",
            description = "صراع النفوذ بين الأسود والضباع في سهول السافانا المفتوحة",
            isLiveNow = false
        ),
        ProgramSchedule(
            channelId = "nasa_tv_live",
            time = "الآن",
            title = "بث محطة الفضاء الدولية (ISS Live Stream)",
            description = "إطلالة ساحرة ومباشرة على كوكب الأرض وشروق الشمس المتكرر من المدار الأرضي",
            isLiveNow = true
        ),
        ProgramSchedule(
            channelId = "nasa_tv_live",
            time = "18:00",
            title = "تلسكوب جيمس ويب: ولادة النجوم والمجرات",
            description = "أحدث الكشوفات الفلكية وأعمق الصور المأخوذة للكون الأولي",
            isLiveNow = false
        )
    )
}
