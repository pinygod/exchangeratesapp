plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
    }

    compileOptions {
        sourceCompatibility = Versions.javaSource
        targetCompatibility = Versions.javaTarget
    }

    kotlinOptions {
        jvmTarget = Versions.jvmTarget
    }
}