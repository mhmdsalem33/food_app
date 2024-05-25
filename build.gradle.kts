// Top-level build file where you can add configuration options common to all sub-projects/modules.


buildscript {
    dependencies {
//        classpath ("com.android.tools.build:gradle:8.1.2")
////        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
//        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.48")
//        classpath ("com.novoda:bintray-release:0.9.2")

    }

    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io")}
        maven { url = uri("https://www.jitpack.io") }
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}