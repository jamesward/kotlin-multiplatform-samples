plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {
    androidLibrary {
        namespace = "com.example.hellokmp.shared"
        compileSdk = 34
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    tvosX64()
    tvosArm64()
    tvosSimulatorArm64()

    watchosX64()
    watchosArm64()
    watchosSimulatorArm64()

    androidNativeX64()
    androidNativeArm64()

    jvm()

    linuxX64()
    linuxArm64()

    macosX64()
    macosArm64()

    mingwX64()

    wasmWasi {
        binaries.library()
        nodejs()
    }
    wasmJs {
        binaries.library()
        browser()
    }

    sourceSets {
        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

// needed to get the right version of Node for wasmWasi
rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().apply {
    //nodeVersion = "21.6.1"
    nodeVersion = "21.0.0-v8-canary202309143a48826a08"
    nodeDownloadBaseUrl = "https://nodejs.org/download/v8-canary"
}
