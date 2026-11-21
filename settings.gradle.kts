pluginManagement { repositories { google(); mavenCentral(); gradlePluginPortal() } }
dependencyResolutionManagement { repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS); repositories { google(); mavenCentral() } }
rootProject.name = "SonataConnect"
include(":app", ":core", ":media", ":bluetooth", ":connectivity", ":android-auto", ":vehicle-diagnostics", ":ui")
