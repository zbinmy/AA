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
        return listOf(
            DiagnosticItem("wifi", "Wi-Fi radio", if (wifi?.isWifiEnabled == true) SupportState.AVAILABLE_ON_DEVICE else SupportState.NOT_DETECTED,
                "Radio state only. Wi-Fi availability does not prove Android Auto Wireless or Miracast support."),
            DiagnosticItem("wifi-direct", "Wi-Fi Direct discovery", SupportState.REQUIRES_VEHICLE_TEST,
                "No Hyundai receiver is assumed. Discovery requires runtime permission and an actual compatible peer."),
            DiagnosticItem("miracast", "Miracast display", SupportState.NOT_SUPPORTED_BY_APP,
                "Android public APIs do not provide a universal third-party Miracast source workflow on all devices."),
            DiagnosticItem("usb", "USB host / data path", if (usb != null) SupportState.AVAILABLE_ON_DEVICE else SupportState.NOT_DETECTED,
                "USB manager availability does not establish a data connection to the vehicle. Verify with a data cable and Android Auto launch.")
        )
    }
}
