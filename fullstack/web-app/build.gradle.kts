import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        named("wasmJsMain") {
            dependencies {
                implementation(project(":shared"))
                implementation(libs.kotlinx.html)
            }
        }
    }

}
