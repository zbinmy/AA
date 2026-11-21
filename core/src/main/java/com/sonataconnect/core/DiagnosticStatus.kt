package com.sonataconnect.core

enum class SupportState { SUPPORTED_BY_DOCUMENTATION, AVAILABLE_ON_DEVICE, NOT_DETECTED, REQUIRES_VEHICLE_TEST, NOT_SUPPORTED_BY_APP, UNKNOWN }

data class DiagnosticItem(
    val id: String,
    val title: String,
    val state: SupportState,
    val detail: String
)
