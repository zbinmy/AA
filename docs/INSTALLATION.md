# Build and installation (developer foundation)

## Requirements
- Android Studio with JDK 17
- Android SDK Platform 37 (Android 17) and matching build tools
- Android phone running Android 8.0 or newer; compileSdk and targetSdk are set to Android 17 / API 37
- USB data cable for factory Android Auto connection

## Build debug APK
1. Clone this repository and check out `feature/sonata-connect-foundation`.
2. Open the root folder in Android Studio.
3. Allow Gradle sync to finish.
4. Run **Build → Make Project**.
5. Run **app → assembleDebug** (or `./gradlew :app:assembleDebug` after adding the standard Gradle wrapper).
6. Install `app/build/outputs/apk/debug/app-debug.apk` on a test phone.

The repository currently does not contain the Gradle wrapper JAR or a built APK. The build has not yet been executed in CI or on a local Android SDK in this task.

## Vehicle connection
1. In the Sonata, open Setup → Device Connections and confirm Android Auto is enabled.
2. Connect the phone to the front USB data/smartphone port with a known-good data cable.
3. Approve Android Auto prompts on the phone and head unit.
4. Keep factory Bluetooth pairing for hands-free calling and media audio. Android Auto and Bluetooth are separate paths; verify which source the head unit is using.
5. Do not expect the app to mirror the phone screen. Android Auto displays only apps and content exposed through its supported in-car APIs and subject to Google eligibility/policy.

## Permissions
Bluetooth state diagnostics require the Nearby devices permission on Android 12+. Media library access will require the relevant Android media permission or Storage Access Framework picker in the media implementation stage. Grant only permissions when the corresponding feature is used.

## Release signing
Create a private upload/release keystore outside the repository. Configure signing through local Gradle properties or CI secrets. Never store passwords or keystore files in Git. A signed release and verified APK checksum will be delivered only after build and test stages are completed.
