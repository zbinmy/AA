package com.sonataconnect.vehiclediagnostics

import com.sonataconnect.core.DiagnosticItem
import com.sonataconnect.core.SupportState

data class ConfirmedHeadUnit(
    val modelCode: String,
    val platform: String,
    val installedSoftware: String,
    val installedMap: String,
    val catalogSoftware: String,
    val catalogMap: String
)

object VehicleCompatibility {
    val confirmedHeadUnit = ConfirmedHeadUnit(
        modelCode = "DN8AS.S5BMC.US",
        platform = "Standard Gen5W Navigation",
        installedSoftware = "DN8.USA.S5W_M.V015.012.260507",
        installedMap = "NAM.19.41.41.010.512.0",
        catalogSoftware = "DN8.USA.S5W_M.V016.010.260903",
        catalogMap = "NAM.19.45.67.021.512.0"
    )

    fun documentedBaseline(): List<DiagnosticItem> = listOf(
        DiagnosticItem("sonata-aa-usb", "Hyundai Android Auto (USB)", SupportState.SUPPORTED_BY_DOCUMENTATION,
            "Expected factory projection path for the confirmed US Standard Gen5W navigation head unit; verify by connecting to the vehicle USB data port."),
        DiagnosticItem("sonata-aa-wireless", "Hyundai Android Auto (wireless)", SupportState.REQUIRES_VEHICLE_TEST,
            "Not established for model " + confirmedHeadUnit.modelCode + ". The Hyundai wireless bulletin located applies to Display Audio Value non-navigation hardware."),
        DiagnosticItem("sonata-mirroring", "Factory screen mirroring", SupportState.NOT_SUPPORTED_BY_APP,
            "Sonata Connect does not implement unrestricted screen mirroring."),
        DiagnosticItem("sonata-video", "Video while driving", SupportState.NOT_SUPPORTED_BY_APP,
            "Video playback is disabled while driving; no safety interlock bypass is implemented."),
        DiagnosticItem("sonata-software-update", "Head-unit software update", SupportState.REQUIRES_VEHICLE_TEST,
            "Installed " + confirmedHeadUnit.installedSoftware + "; Hyundai catalog lists " + confirmedHeadUnit.catalogSoftware + " for this model. Confirm through Hyundai's official update tool before installing.")
    )
}
