buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.0")
        classpath("com.google.gms:google-services:4.3.10")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.application) version Versions.application apply false
    id(Plugins.androidLibrary) version Versions.androidLibrary apply false
    kotlin(Plugins.android) version Versions.android apply false
    id(Plugins.hilt) version Versions.hilt apply false
    id(Plugins.safeArgs) version Versions.safeArgs apply false
    id(Plugins.kotlinJvm) version Versions.kotlinJvm apply false
}