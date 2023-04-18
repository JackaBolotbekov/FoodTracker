plugins {
    Plugins.apply {
        id(androidLibrary)
        kotlin(android)
        kotlin(kapt)
        id(hilt)
        id(googleServices)
    }
}

android {
    namespace = Config.namespaceData
    compileSdk = Config.compileAndTargetSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {

    Dependencies.UIComponents.apply {
        // Core
        implementation(core)
        // AppCompat
        implementation(appCompat)
        // Material Design
        implementation(material)
        // UI Components
        implementation(constraint)
        implementation(legacy)
        implementation(lifecycle)
    }

    Dependencies.Hilt.apply {
        // Hilt
        implementation(hilt)
        kapt(hiltCompiler)
    }

    Dependencies.Firebase.apply {
        // Firestore
        implementation(firestore)
    }

    // domain
    implementation(project(":domain"))
}