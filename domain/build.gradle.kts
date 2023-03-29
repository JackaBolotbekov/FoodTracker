plugins {
    Plugins.apply {
        id(javaLibrary)
        id(kotlinJvm)
    }
}

dependencies {
    implementation(Dependencies.Coroutines.coroutines)
    implementation(Dependencies.Inject.inject)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}