plugins {
    Plugins.apply {
        id(androidLibrary)
        kotlin(android)
        kotlin(kapt)
        id(hilt)
        id(googleServices)
        id(safeArgs)
    }
//    id("org.jetbrains.kotlin.android")
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
        jvmTarget = "1.8"
    }

    buildFeatures.viewBinding = true
}

dependencies {
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
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

    Dependencies.Domain.apply {
        implementation(project(domain))
    }
    Dependencies.Data.apply {
        implementation(project(data))
    }
    implementation ("androidx.core:core-splashscreen:1.0.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}