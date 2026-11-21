package com.sonataconnect.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonataconnect.bluetooth.BluetoothDiagnostics
import com.sonataconnect.connectivity.ConnectivityDiagnostics
import com.sonataconnect.core.DiagnosticItem
import com.sonataconnect.core.SupportState

private val Graphite = Color(0xFF0A0D12)
private val Panel = Color(0xFF151B24)
private val Accent = Color(0xFF58B8FF)
private val Muted = Color(0xFF9AA8B8)

@Composable
fun SonataConnectRoot() {
    val context = LocalContext.current
    var refresh by remember { mutableIntStateOf(0) }
    val deviceChecks = remember(context, refresh) {
        BluetoothDiagnostics(context).inspect() + ConnectivityDiagnostics(context).inspect()
    }
    MaterialTheme(colorScheme = darkColorScheme(primary = Accent, background = Graphite, surface = Panel)) {
        Scaffold(containerColor = Graphite) { padding ->
            Column(Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()).padding(24.dp)) {
                Text("SONATA CONNECT", color = Color.White, fontSize = 13.sp, letterSpacing = 3.sp)
                Spacer(Modifier.height(24.dp))
                Text("Your drive. Your sound.", color = Color.White, fontSize = 30.sp)
                Text("2021 SONATA DN8  •  ANDROID 17", color = Muted, fontSize = 11.sp, letterSpacing = 1.sp)
                Spacer(Modifier.height(24.dp))
                StatusPanel("FACTORY PROJECTION", "Android Auto over USB", "Documented in 2021 Sonata quick reference guide", "DOCUMENTED")
                StatusPanel("WIRELESS PROJECTION", "Not confirmed for navigation head unit", "Hyundai wireless bulletin found applies to non-navigation Display Audio Value.", "VERIFY")
                StatusPanel("BLUETOOTH MEDIA", "Vehicle pairing test required", "A2DP, AVRCP and HFP are separate profiles; phone radio state does not prove vehicle negotiation.", "TEST")
                StatusPanel("SCREEN MIRRORING", "Not implemented", "No unsupported Miracast or unrestricted screen mirroring capability is advertised.", "N/A")
                Spacer(Modifier.height(24.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("PHONE DIAGNOSTICS", color = Accent, fontSize = 12.sp, letterSpacing = 2.sp)
                    TextButton(onClick = { refresh++ }) { Text("REFRESH") }
                }
                deviceChecks.forEach { item ->
                    DiagnosticRow(item)
                }
                Spacer(Modifier.height(24.dp))
                Text("CURRENT SESSION", color = Accent, fontSize = 12.sp, letterSpacing = 2.sp)
                Spacer(Modifier.height(8.dp))
                Text("No media selected", color = Color.White, fontSize = 22.sp)
                Text("Connect your phone to the vehicle's USB data port to launch factory Android Auto.", color = Muted)
                Spacer(Modifier.height(28.dp))
                Text("Vehicle compatibility remains provisional until the installed head-unit software is identified and the connection is tested in the car.", color = Muted, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun StatusPanel(title: String, value: String, detail: String, tag: String) {
    Card(Modifier.fillMaxWidth().padding(vertical = 6.dp), colors = CardDefaults.cardColors(containerColor = Panel)) {
        Column(Modifier.padding(18.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(title, color = Accent, fontSize = 11.sp, letterSpacing = 1.4.sp)
                Text(tag, color = Muted, fontSize = 10.sp)
            }
            Spacer(Modifier.height(8.dp))
            Text(value, color = Color.White, fontSize = 18.sp)
            Spacer(Modifier.height(4.dp))
            Text(detail, color = Muted, fontSize = 12.sp)
        }
    }
}

@Composable
private fun DiagnosticRow(item: DiagnosticItem) {
    val stateText = when (item.state) {
        SupportState.SUPPORTED_BY_DOCUMENTATION -> "DOCUMENTED"
        SupportState.AVAILABLE_ON_DEVICE -> "AVAILABLE"
        SupportState.NOT_DETECTED -> "NOT DETECTED"
        SupportState.REQUIRES_VEHICLE_TEST -> "VEHICLE TEST"
        SupportState.NOT_SUPPORTED_BY_APP -> "NOT IMPLEMENTED"
        SupportState.UNKNOWN -> "UNKNOWN"
    }
    Card(Modifier.fillMaxWidth().padding(vertical = 4.dp), colors = CardDefaults.cardColors(containerColor = Panel)) {
        Column(Modifier.padding(14.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(item.title, color = Color.White, fontSize = 14.sp)
                Text(stateText, color = Accent, fontSize = 10.sp)
            }
            Spacer(Modifier.height(3.dp))
            Text(item.detail, color = Muted, fontSize = 11.sp)
        }
    }
}
