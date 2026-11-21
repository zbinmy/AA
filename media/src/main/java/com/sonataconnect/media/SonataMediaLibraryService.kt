package com.sonataconnect.media

import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaLibraryService
import androidx.media3.session.MediaSession

/**
 * Media3 service entry point for Android Auto's media browser.
 * A real catalog and playback persistence are intentionally not claimed in this foundation build.
 */
class SonataMediaLibraryService : MediaLibraryService() {
    private var exoPlayer: ExoPlayer? = null
    private var librarySession: MediaLibrarySession? = null

    override fun onCreate() {
        super.onCreate()
        val player = ExoPlayer.Builder(this).build()
        exoPlayer = player
        librarySession = MediaLibrarySession.Builder(this, player, EmptyLibraryCallback()).build()
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaLibrarySession? = librarySession

    override fun onDestroy() {
        librarySession?.release()
        librarySession = null
        exoPlayer?.release()
        exoPlayer = null
        super.onDestroy()
    }

    private class EmptyLibraryCallback : MediaLibrarySession.Callback
}
