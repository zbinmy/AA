package com.sonataconnect.bluetooth

import android.Manifest
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import com.sonataconnect.core.DiagnosticItem
import com.sonataconnect.core.SupportState

class BluetoothDiagnostics(private val context: Context) {
    fun inspect(): List<DiagnosticItem> {
        val manager = context.getSystemService(BluetoothManager::class.java)
        val adapter = manager?.adapter
        val hasConnect = Build.VERSION.SDK_INT < 31 ||
            ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
        val state = when {
            adapter == null -> SupportState.NOT_DETECTED
            !hasConnect -> SupportState.UNKNOWN
            adapter.isEnabled -> SupportState.AVAILABLE_ON_DEVICE
            else -> SupportState.NOT_DETECTED
        }
        val note = when {
            adapter == null -> "This phone reports no Bluetooth adapter."
            !hasConnect -> "Grant Nearby devices permission to read Bluetooth state."
            adapter.isEnabled -> "Bluetooth radio is enabled. A2DP/AVRCP/HFP negotiation with the vehicle must be tested separately."
            else -> "Bluetooth is disabled on the phone."
        }
        return listOf(
            DiagnosticItem("bt-radio", "Bluetooth radio", state, note),
            DiagnosticItem("a2dp", "Bluetooth A2DP audio", SupportState.REQUIRES_VEHICLE_TEST, "Android app cannot confirm the Sonata's active A2DP route until the phone is paired and audio is routed."),
            DiagnosticItem("avrcp", "Bluetooth AVRCP controls", SupportState.REQUIRES_VEHICLE_TEST, "Verify track skip and metadata on the factory head unit."),
            DiagnosticItem("hfp", "Bluetooth hands-free calling", SupportState.REQUIRES_VEHICLE_TEST, "Leave calling to Android and the factory Bluetooth hands-free connection.")
        )
    }
}
