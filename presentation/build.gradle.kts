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
    namespace = Config.namespacePresentation
    compileSdk = Config.compileAndTargetSdk

    defaultConfig {
        minSdk = Config.minSdk

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

    buildFeatures.viewBinding = true
}

dependencies {
    Dependencies.UIComponents.apply {
        implementation(core)
        implementation(appCompat)
        implementation(material)
    }

    Dependencies.Activity.apply {
        implementation(activity)
    }

    Dependencies.Fragment.apply {
        implementation(fragment)
    }

    Dependencies.Navigation.apply {
        implementation(navigation)
        implementation(navigationUi)
    }

    Dependencies.Lifecycle.apply {
        implementation(lifecycle)
        implementation(lifecycleRuntime)
    }

    Dependencies.ViewBinding.apply {
        implementation(viewBinding)
    }

    Dependencies.Glide.apply {
        implementation(glide)
        annotationProcessor(glideCompiler)
    }

    Dependencies.Hilt.apply {
        implementation(hilt)
        kapt(hiltCompiler)
    }

    Dependencies.Retrofit.apply {
        implementation(retrofit)
        implementation(retrofitConverter)
    }

    Dependencies.DotsIndicator.apply {
        implementation(dotsIndicator)
    }

    Dependencies.Firebase.apply {
        implementation(firestore)
    }

//    implementation ("androidx.core:core-splashscreen:1.1.0-alpha01")

    Dependencies.Domain.apply {
        implementation(project(domain))
    }
    Dependencies.Data.apply {
        implementation(project(data))
    }
}