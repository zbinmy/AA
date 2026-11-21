package com.sonataconnect.androidauto

/**
 * Android Auto integration contract.
 *
 * The app exposes a Media3 MediaLibraryService in the app module. Android Auto renders
 * the media browser UI from that service; it does not host arbitrary Compose screens.
 * Catalog browsing remains pending until the MediaLibrarySession callback is implemented.
 */
object AndroidAutoIntegration {
    const val MEDIA_SERVICE_ACTION = "androidx.media3.session.MediaLibraryService"
    const val VEHICLE_DISPLAY_MIRRORING_SUPPORTED = false
}
