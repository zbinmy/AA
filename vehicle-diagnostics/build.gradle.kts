plugins { alias(libs.plugins.android.library); alias(libs.plugins.kotlin.android) }
android { namespace = "com.sonataconnect.vehiclediagnostics"; compileSdk = 37; defaultConfig { minSdk = 26 }; compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }; kotlinOptions { jvmTarget = "17" } }
dependencies { implementation(project(":core")); implementation(project(":bluetooth")); implementation(project(":connectivity")); implementation(libs.androidx.core.ktx); testImplementation("junit:junit:4.13.2") }
