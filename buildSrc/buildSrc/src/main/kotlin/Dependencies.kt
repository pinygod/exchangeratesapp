object Dependencies {

    object Kotlin {
        private const val version = "1.7.20"

        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.6.4"

            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }
    }

    object Android {
        private const val version = "7.3.1"

        const val gradlePlugin = "com.android.tools.build:gradle:$version"

        object Material {
            private const val version = "1.7.0"

            const val material = "com.google.android.material:material:$version"
        }

        object Navigation {
            private const val version = "2.5.3"

            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        }
    }

    object Room {
        private const val version = "2.4.3"

        const val room = "androidx.room:room-ktx:$version"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object DataStore {
        private const val version = "1.0.0"

        const val preferences = "androidx.datastore:datastore-preferences:$version"
    }

    object Hilt {
        private const val version = "2.44"

        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    object Javax {
        const val inject = "javax.inject:javax.inject:1"
    }
}