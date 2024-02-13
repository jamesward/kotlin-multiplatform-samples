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
        nodejs()
    }
    wasmJs {
        browser()
    }
}