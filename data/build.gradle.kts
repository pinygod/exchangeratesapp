plugins {
    id("android-core-umbrella")
    kotlin("kapt")
}

android {
    namespace = "com.pinygod.exchangeratesapp.data"

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
    api(Dependencies.Paging.common)
    api(Dependencies.Room.room)
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.paging)
    implementation(Dependencies.DataStore.preferences)
    implementation(Dependencies.Javax.inject)
}