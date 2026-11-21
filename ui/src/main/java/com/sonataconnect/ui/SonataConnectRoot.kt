package com.sonataconnect.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Graphite = Color(0xFF0A0D12)
private val Panel = Color(0xFF151B24)
private val Accent = Color(0xFF58B8FF)
private val Muted = Color(0xFF9AA8B8)

@Composable
fun SonataConnectRoot() {
    MaterialTheme(colorScheme = darkColorScheme(primary = Accent, background = Graphite, surface = Panel)) {
        Scaffold(containerColor = Graphite) { padding ->
            Column(Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()).padding(24.dp)) {
                Text("SONATA CONNECT", color = Color.White, fontSize = 13.sp, letterSpacing = 3.sp)
                Spacer(Modifier.height(24.dp))
                Text("Your drive. Your sound.", color = Color.White, fontSize = 30.sp)
                Text("2021 SONATA DN8  •  COMPATIBILITY OVERVIEW", color = Muted, fontSize = 11.sp, letterSpacing = 1.sp)
                Spacer(Modifier.height(24.dp))
                StatusPanel("FACTORY PROJECTION", "Android Auto over USB", "Documented in 2021 Sonata quick reference guide", "WIRED")
                StatusPanel("WIRELESS PROJECTION", "Not confirmed for navigation head unit", "Wireless bulletin found applies to non-navigation Display Audio Value.", "VERIFY")
                StatusPanel("BLUETOOTH AUDIO", "Available on phone", "A2DP / AVRCP / HFP behavior requires a real vehicle pairing test.", "TEST")
                StatusPanel("SCREEN MIRRORING", "Not implemented", "No unsupported mirroring protocol is advertised.", "N/A")
                Spacer(Modifier.height(24.dp))
                Text("CURRENT SESSION", color = Accent, fontSize = 12.sp, letterSpacing = 2.sp)
                Spacer(Modifier.height(8.dp))
                Text("No media selected", color = Color.White, fontSize = 22.sp)
                Text("Connect your phone to the vehicle's USB data port to launch factory Android Auto.", color = Muted)
                Spacer(Modifier.height(28.dp))
                Text("Compatibility findings are provisional until checked against the installed head-unit software and tested in the vehicle.", color = Muted, fontSize = 12.sp)
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
