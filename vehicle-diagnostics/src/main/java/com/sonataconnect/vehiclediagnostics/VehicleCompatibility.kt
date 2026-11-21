package com.sonataconnect.vehiclediagnostics

import com.sonataconnect.core.DiagnosticItem
import com.sonataconnect.core.SupportState

object VehicleCompatibility {
    fun documentedBaseline(): List<DiagnosticItem> = listOf(
        DiagnosticItem("sonata-aa-usb", "Hyundai Android Auto (USB)", SupportState.SUPPORTED_BY_DOCUMENTATION,
            "2021 Sonata Quick Reference Guide documents Android Auto through the USB data/smartphone port."),
        DiagnosticItem("sonata-aa-wireless", "Hyundai Android Auto (wireless)", SupportState.REQUIRES_VEHICLE_TEST,
            "Wireless setup bulletin located applies to Display Audio Value non-navigation. Do not assume it applies to the 10.25-inch navigation unit."),
        DiagnosticItem("sonata-mirroring", "Factory screen mirroring", SupportState.NOT_SUPPORTED_BY_APP,
            "Sonata Connect does not implement unrestricted screen mirroring."),
        DiagnosticItem("sonata-video", "Video while driving", SupportState.NOT_SUPPORTED_BY_APP,
            "Video playback is disabled while driving; no safety interlock bypass is implemented.")
    )
}
