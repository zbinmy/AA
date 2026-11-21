# SONATA CONNECT

Android/Kotlin project for a safe media companion targeting a 2021 Hyundai Sonata DN8 factory infotainment system.

## Current delivery state

**Foundation build only — not a production release.** Stage 1 compatibility research is documented in [docs/VEHICLE_COMPATIBILITY.md](docs/VEHICLE_COMPATIBILITY.md). The repository now contains a multi-module Android project, a Compose dashboard, initial Bluetooth/Wi-Fi/USB diagnostics, and a Media3 `MediaLibraryService` entry point.

Not yet implemented: full MediaStore library indexing, playable queue and playlist persistence, complete runtime permission UX, active A2DP/AVRCP/HFP profile verification, Wi-Fi Direct peer scanning, parked-state video enforcement, signed release artifact, and physical vehicle validation. The Media3 library callback is currently empty; Android Auto browsing is not yet a usable catalog.

## Vehicle compatibility position

For the assumed US 2021 Sonata Limited with 10.25-inch navigation: wired Android Auto is documented through the USB data/smartphone port. Wireless Android Auto is **not established** for this navigation unit; Hyundai's 2021 wireless projection bulletin is scoped to Display Audio Value non-navigation units. Factory Bluetooth streaming/hands-free calling are supported, but profile-level behavior must be tested on the actual car. Arbitrary screen mirroring is not a supported Android Auto media-app capability.

## Project modules

- `app` — Android entry point, manifest, Hilt bootstrap
- `core` — shared diagnostic models
- `media` — Media3 session service (catalog pending)
- `bluetooth` — public Android Bluetooth state diagnostics
- `connectivity` — Wi-Fi and USB capability diagnostics
- `android-auto` — Android Auto integration boundary
- `vehicle-diagnostics` — documented Sonata baseline
- `ui` — Jetpack Compose dashboard

## Build

Open the repository root in Android Studio with JDK 17 and Android SDK 36 installed, then run the Gradle sync and assembleDebug task. The project does not include a signing key. A release APK must be signed by the owner with a private keystore; do not commit that keystore.

## Safety

No root access, privileged APIs, speed spoofing, motion restriction bypass, or factory head-unit modifications are used. Video playback is not implemented in this foundation build. Do not use the phone app's video playback while driving.
