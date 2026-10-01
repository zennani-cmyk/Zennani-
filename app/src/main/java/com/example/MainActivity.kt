package com.example

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLink
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.outlined.AddLink
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LiveTv
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.ChannelCategory
import com.example.ui.player.VideoPlayerView
import com.example.ui.screens.AddCustomChannelScreen
import com.example.ui.screens.EpgScreen
import com.example.ui.screens.FavoritesScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.theme.AlahmadTvTheme
import com.example.ui.theme.BackgroundDark
import com.example.ui.theme.CyanPrimary
import com.example.ui.theme.RedLive
import com.example.ui.theme.SurfaceDark
import com.example.ui.viewmodel.ChannelViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: ChannelViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlahmadTvTheme {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    MainScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: ChannelViewModel) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    val allChannels by viewModel.allChannels.collectAsStateWithLifecycle()
    val filteredChannels by viewModel.filteredChannels.collectAsStateWithLifecycle()
    val favoriteChannels by viewModel.favoriteChannels.collectAsStateWithLifecycle()
    val favoriteIds by viewModel.favoriteIds.collectAsStateWithLifecycle()
    val watchHistory by viewModel.watchHistory.collectAsStateWithLifecycle()
    val selectedCategory by viewModel.selectedCategory.collectAsStateWithLifecycle()
    val selectedCountry by viewModel.selectedCountry.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val activePlayingChannel by viewModel.activePlayingChannel.collectAsStateWithLifecycle()

    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    var showAboutDialog by remember { mutableStateOf(false) }

    // If activePlayingChannel is present in landscape, let VideoPlayerView occupy full screen
    if (activePlayingChannel != null && isLandscape) {
        VideoPlayerView(
            channel = activePlayingChannel!!,
            onClosePlayer = { viewModel.closePlayer() },
            onPreviousChannel = { viewModel.previousChannel() },
            onNextChannel = { viewModel.nextChannel() },
            modifier = Modifier.fillMaxSize()
        )
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = CyanPrimary.copy(alpha = 0.2f),
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.LiveTv,
                                    contentDescription = "Logo",
                                    tint = CyanPrimary,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "أباحاحا الأحمد تيفي",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 17.sp,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Surface(
                                    color = RedLive,
                                    shape = RoundedCornerShape(4.dp)
                                ) {
                                    Text(
                                        text = "LIVE",
                                        color = Color.White,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                    )
                                }
                            }
                            Text(
                                text = "بث القنوات العربية والعالمية",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                },
                actions = {
                    IconButton(
                        onClick = { showAboutDialog = true },
                        modifier = Modifier.testTag("about_app_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "About App",
                            tint = CyanPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = SurfaceDark
                ),
                modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = SurfaceDark,
                contentColor = Color.White,
                modifier = Modifier
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .testTag("bottom_nav_bar")
            ) {
                NavigationBarItem(
                    selected = selectedTabIndex == 0,
                    onClick = { selectedTabIndex = 0 },
                    icon = {
                        Icon(
                            imageVector = if (selectedTabIndex == 0) Icons.Filled.Tv else Icons.Outlined.LiveTv,
                            contentDescription = "Channels"
                        )
                    },
                    label = { Text("القنوات", fontSize = 11.sp) },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = CyanPrimary,
                        selectedIconColor = Color.Black,
                        selectedTextColor = CyanPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    modifier = Modifier.testTag("nav_tab_channels")
                )

                NavigationBarItem(
                    selected = selectedTabIndex == 1,
                    onClick = { selectedTabIndex = 1 },
                    icon = {
                        Icon(
                            imageVector = if (selectedTabIndex == 1) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favorites"
                        )
                    },
                    label = { Text("المفضلة", fontSize = 11.sp) },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = CyanPrimary,
                        selectedIconColor = Color.Black,
                        selectedTextColor = CyanPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    modifier = Modifier.testTag("nav_tab_favorites")
                )

                NavigationBarItem(
                    selected = selectedTabIndex == 2,
                    onClick = { selectedTabIndex = 2 },
                    icon = {
                        Icon(
                            imageVector = if (selectedTabIndex == 2) Icons.Filled.Schedule else Icons.Outlined.Schedule,
                            contentDescription = "EPG"
                        )
                    },
                    label = { Text("دليل البرامج", fontSize = 11.sp) },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = CyanPrimary,
                        selectedIconColor = Color.Black,
                        selectedTextColor = CyanPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    modifier = Modifier.testTag("nav_tab_epg")
                )

                NavigationBarItem(
                    selected = selectedTabIndex == 3,
                    onClick = { selectedTabIndex = 3 },
                    icon = {
                        Icon(
                            imageVector = if (selectedTabIndex == 3) Icons.Filled.AddLink else Icons.Outlined.AddLink,
                            contentDescription = "Add Link"
                        )
                    },
                    label = { Text("إضافة رابط", fontSize = 11.sp) },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = CyanPrimary,
                        selectedIconColor = Color.Black,
                        selectedTextColor = CyanPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    modifier = Modifier.testTag("nav_tab_custom")
                )
            }
        },
        containerColor = BackgroundDark,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Live Video Player Dock (if active)
            AnimatedVisibility(
                visible = activePlayingChannel != null,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                if (activePlayingChannel != null) {
                    VideoPlayerView(
                        channel = activePlayingChannel!!,
                        onClosePlayer = { viewModel.closePlayer() },
                        onPreviousChannel = { viewModel.previousChannel() },
                        onNextChannel = { viewModel.nextChannel() }
                    )
                }
            }

            // Screen Content according to selected tab
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                when (selectedTabIndex) {
                    0 -> HomeScreen(
                        channels = filteredChannels,
                        favoriteIds = favoriteIds,
                        selectedCategory = selectedCategory,
                        selectedCountry = selectedCountry,
                        searchQuery = searchQuery,
                        onCategorySelected = { viewModel.setCategory(it) },
                        onCountrySelected = { viewModel.setCountry(it) },
                        onSearchQueryChanged = { viewModel.setSearchQuery(it) },
                        onChannelClick = { viewModel.selectChannel(it) },
                        onToggleFavorite = { viewModel.toggleFavorite(it) }
                    )

                    1 -> FavoritesScreen(
                        favoriteChannels = favoriteChannels,
                        watchHistory = watchHistory,
                        allChannels = allChannels,
                        onChannelClick = { viewModel.selectChannel(it) },
                        onToggleFavorite = { viewModel.toggleFavorite(it) },
                        onClearHistory = { viewModel.clearHistory() },
                        onBrowseChannelsClick = { selectedTabIndex = 0 }
                    )

                    2 -> EpgScreen(
                        channels = allChannels,
                        getSchedulesForChannel = { viewModel.getSchedules(it) },
                        onWatchChannel = { viewModel.selectChannel(it) }
                    )

                    3 -> {
                        val customChannels = allChannels.filter { it.isCustom }
                        AddCustomChannelScreen(
                            customChannels = customChannels,
                            onAddChannel = { nameAr, nameEn, url, cat, country, logo ->
                                viewModel.addCustomChannel(nameAr, nameEn, url, cat, country, logo)
                            },
                            onDeleteChannel = { viewModel.deleteCustomChannel(it) },
                            onPlayChannel = { viewModel.selectChannel(it) }
                        )
                    }
                }
            }
        }
    }

    // About & Features Dialog
    if (showAboutDialog) {
        AlertDialog(
            onDismissRequest = { showAboutDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LiveTv,
                        contentDescription = "TV",
                        tint = CyanPrimary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "عن تطبيق أباحاحا الأحمد تيفي",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            },
            text = {
                Column(modifier = Modifier.padding(top = 4.dp)) {
                    Text(
                        text = "تطبيق أباحاحا الأحمد تيفي يتيح لك مشاهدة البث الحي المباشر لأشهر القنوات التلفزيونية العربية والعالمية بجودة عالية وثبات فائق.",
                        fontSize = 13.sp,
                        color = Color.White,
                        lineHeight = 18.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "المميزات الرئيسية:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = CyanPrimary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "• باقة شاملة: أخبار، قرآن كريم ومكة والمدينة مباشر، رياضة، أطفال، وثائقي، وترفيه.\n" +
                                "• مشغل وسائط متقدم يدعم البث المباشر (HLS) مع ملء الشاشة وتعديل الأبعاد.\n" +
                                "• ميزة الاستماع الصوتي لتوفير شحن البطارية.\n" +
                                "• مؤقت نوم ذكي للإيقاف التلقائي للبث.\n" +
                                "• حفظ القنوات المفضلة وسجل المشاهدة عبر قاعدة بيانات Room.\n" +
                                "• إمكانية إضافة روابط وباقات IPTV و M3U8 خاصة بك.",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 17.sp
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = { showAboutDialog = false }) {
                    Text("تم", color = CyanPrimary, fontWeight = FontWeight.Bold)
                }
            }
        )
    }
}
