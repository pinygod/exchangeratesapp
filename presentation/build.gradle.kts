plugins {
    id("android-core-umbrella")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(":domain"))

    implementation(Dependencies.Android.Material.material)
    implementation(Dependencies.Android.Navigation.fragment)
    implementation(Dependencies.Android.Navigation.ui)
    implementation(Dependencies.Hilt.android)
    implementation(Dependencies.Paging.android)
    kapt(Dependencies.Hilt.compiler)
}