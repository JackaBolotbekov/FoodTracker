plugins {
    Plugins.apply {
        id(javaLibrary)
        id(kotlinJvm)
        id(googleServices)

    }
}

dependencies {
    implementation(Dependencies.Coroutines.coroutines)
    implementation(Dependencies.Inject.inject)
    implementation(Dependencies.Firebase.firestore)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}