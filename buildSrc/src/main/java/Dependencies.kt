object Dependencies {

    object UIComponents{
        const val core = "androidx.core:core-ktx:1.9.0"
        const val appCompat = "androidx.appcompat:appcompat:1.6.1"
        const val material = "com.google.android.material:material:1.8.0"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.1.4"
    }

    object Hilt{
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object OkHttp{
        const val okHttpBom = "com.squareup.okhttp3:okhttp-bom:${Versions.okHttp}"
        const val okHttp = "com.squareup.okhttp3:okhttp"
        const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor"
    }

    object Retrofit{
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Glide{
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object ViewBinding{
        const val viewBinding = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.viewBinding}"
    }

    object Lifecycle{
        const val lifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycles}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycles}"
    }

    object Navigation{
        const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Fragment{
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }

    object Activity{
        const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    }

    object Coroutines{
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object Inject{
        const val inject = "javax.inject:javax.inject:${Versions.inject}"
    }

    object Domain{
        const val domain = ":domain"
    }

    object Presentation{
        const val presentation = ":presentation"
    }

    object Data{
        const val data = ":data"
    }
}