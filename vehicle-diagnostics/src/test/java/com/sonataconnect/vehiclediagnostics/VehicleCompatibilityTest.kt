package com.sonataconnect.vehiclediagnostics

import com.sonataconnect.core.SupportState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class VehicleCompatibilityTest {
    @Test fun wiredAndroidAutoIsDocumented() {
        val item = VehicleCompatibility.documentedBaseline().first { it.id == "sonata-aa-usb" }
        assertEquals(SupportState.SUPPORTED_BY_DOCUMENTATION, item.state)
    }

    @Test fun wirelessProjectionIsNotAssumedSupported() {
        val item = VehicleCompatibility.documentedBaseline().first { it.id == "sonata-aa-wireless" }
        assertEquals(SupportState.REQUIRES_VEHICLE_TEST, item.state)
        assertTrue(item.detail.contains("non-navigation"))
    }

    @Test fun videoSafetyRestrictionIsExplicit() {
        val item = VehicleCompatibility.documentedBaseline().first { it.id == "sonata-video" }
        assertEquals(SupportState.NOT_SUPPORTED_BY_APP, item.state)
    }
}
