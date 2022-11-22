plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = Versions.javaSource
    targetCompatibility = Versions.javaTarget
}

dependencies {
    implementation(Dependencies.Kotlin.Coroutines.core)
    implementation(Dependencies.Javax.inject)
}