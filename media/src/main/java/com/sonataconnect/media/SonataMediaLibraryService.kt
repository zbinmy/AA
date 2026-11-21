package com.sonataconnect.media

import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaLibraryService
import androidx.media3.session.MediaLibrarySession

class SonataMediaLibraryService : MediaLibraryService() {
    private var player: ExoPlayer? = null
    private var librarySession: MediaLibrarySession? = null

    override fun onCreate() {
        super.onCreate()
        val exoPlayer = ExoPlayer.Builder(this).build()
        player = exoPlayer
        librarySession = MediaLibrarySession.Builder(this, exoPlayer, EmptyLibraryCallback()).build()
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaLibrarySession? = librarySession

    override fun onDestroy() {
        librarySession?.run { player.release(); release() }
        librarySession = null
        player = null
        super.onDestroy()
    }

    private class EmptyLibraryCallback : MediaLibrarySession.Callback
}
