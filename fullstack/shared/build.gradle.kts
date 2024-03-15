import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {
    androidLibrary {
        @Suppress("UnstableApiUsage")
        withAndroidTestOnJvm { }
        @Suppress("UnstableApiUsage")
        namespace = "com.example.fullstack.shared"
        @Suppress("UnstableApiUsage")
        compileSdk = 34
    }

    iosX64 {
        binaries {
            framework {
                baseName = "TaxesShared"
            }
        }
    }
    iosArm64 {
        binaries {
            framework {
                baseName = "TaxesShared"
            }
        }
    }
    iosSimulatorArm64 {
        binaries {
            framework {
                baseName = "TaxesShared"
            }
        }
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        binaries.library()
        browser()
    }

    jvm()

    sourceSets {
        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<AbstractTestTask> {
    testLogging {
        showStandardStreams = true
        showExceptions = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        events(
            org.gradle.api.tasks.testing.logging.TestLogEvent.STARTED,
            org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
            org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED,
            org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
        )
    }
}
