plugins {
    Plugins.apply {
        id(androidLibrary)
        kotlin(android)
    }
}
android {
    namespace = Config.namespaceData
    compileSdk = Config.compileAndTargetSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.compileAndTargetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles(Config.consumer)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(Config.proguard), Config.proguardRules)
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
        implementation(core)
        implementation(appCompat)
        implementation(material)
    }
}