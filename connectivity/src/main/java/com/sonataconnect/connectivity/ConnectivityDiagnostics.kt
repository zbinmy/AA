package com.sonataconnect.connectivity

import android.content.Context
import android.hardware.usb.UsbManager
import android.net.wifi.WifiManager
import com.sonataconnect.core.DiagnosticItem
import com.sonataconnect.core.SupportState

class ConnectivityDiagnostics(private val context: Context) {
    @Suppress("DEPRECATION")
    fun inspect(): List<DiagnosticItem> {
        val wifi = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as? WifiManager
        val usb = context.getSystemService(Context.USB_SERVICE) as? UsbManager
        val wifiState = try {
            if (wifi?.isWifiEnabled == true) SupportState.AVAILABLE_ON_DEVICE else SupportState.NOT_DETECTED
        } catch (_: SecurityException) {
            SupportState.UNKNOWN
        }
        val wifiDetail = when (wifiState) {
            SupportState.AVAILABLE_ON_DEVICE -> "Wi-Fi radio is enabled. This does not prove Android Auto Wireless or Miracast support."
            SupportState.NOT_DETECTED -> "Wi-Fi radio is disabled or unavailable."
            else -> "Android restricted access to Wi-Fi state; grant the relevant Nearby devices permission if required."
        }
        return listOf(
            DiagnosticItem("wifi", "Wi-Fi radio", wifiState, wifiDetail),
            DiagnosticItem("wifi-direct", "Wi-Fi Direct discovery", SupportState.REQUIRES_VEHICLE_TEST,
                "No Hyundai receiver is assumed. Peer discovery and connection are not implemented in this build."),
            DiagnosticItem("miracast", "Miracast display", SupportState.NOT_SUPPORTED_BY_APP,
                "No universal third-party Miracast source workflow is implemented."),
            DiagnosticItem("usb", "USB manager", if (usb != null) SupportState.AVAILABLE_ON_DEVICE else SupportState.NOT_DETECTED,
                "Android USB service is present. This does not confirm a USB data connection to the vehicle.")
        )
    }
}
