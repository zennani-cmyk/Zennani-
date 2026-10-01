package com.example.ui.player

import com.example.data.model.Channel

enum class ResizeMode {
    FIT,
    ZOOM,
    FILL
}

data class PlayerUiState(
    val currentChannel: Channel? = null,
    val isPlaying: Boolean = true,
    val isBuffering: Boolean = false,
    val isMuted: Boolean = false,
    val isAudioOnly: Boolean = false,
    val isFullscreen: Boolean = false,
    val resizeMode: ResizeMode = ResizeMode.FIT,
    val errorMessage: String? = null,
    val sleepTimerMinutesLeft: Int? = null,
    val showControls: Boolean = true
)
