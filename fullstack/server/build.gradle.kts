import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {

    jvm {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        mainRun {
            mainClass = "com.example.fullstack.server.MainKt"
        }
    }

    sourceSets {
        jvmMain {
            dependencies {
                implementation(project(":shared"))
                implementation(libs.ktor.server.core)
                implementation(libs.ktor.server.cio)
                runtimeOnly(libs.slf4j.simple)
            }
        }
    }

}
