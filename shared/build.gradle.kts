plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.skie)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.skie.annotations)
            implementation(libs.androidx.paging.common)
            implementation(libs.androidx.room.runtime)
            implementation(libs.sqlite.bundled)
            implementation(libs.kotlinx.atomicfu)
            api(libs.androidx.datastore.preferences.core)
            api(libs.androidx.datastore.core.okio)
            implementation(libs.okio)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
            implementation(libs.androidx.room.paging)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }


        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.nikola.kotlinmultiplatformexample"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    ksp(libs.androidx.room.compiler)
    add("kspAndroid", libs.androidx.room.compiler)
    add("kspIosSimulatorArm64", libs.androidx.room.compiler)
    add("kspIosX64", libs.androidx.room.compiler)
    add("kspIosArm64", libs.androidx.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}

