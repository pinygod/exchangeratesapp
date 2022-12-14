plugins {
    id("android-core-umbrella")
    kotlin("kapt")
}

android {
    defaultConfig {
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }

    buildTypes {
        all {
            buildConfigField("String", "BASE_URL", "\"https://api.exchangerate.host/\"")
        }
    }
}

dependencies {

    implementation(project(":domain"))

    api(Dependencies.Retrofit.retrofit)
    api(Dependencies.Room.room)
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.paging)
    implementation(Dependencies.Paging.common)
    implementation(Dependencies.DataStore.preferences)
    implementation(Dependencies.Javax.inject)
}