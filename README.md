# Android-Album-Quiz
A quiz on albums! Think you know your albums? Go ahead and take the quiz!

## Setup and Dependencies
Righto, the boring stuff, lets go. Make sure this stuff is in your plugin: 
```
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
    id 'kotlin-android-extensions'
    id 'androidx.navigation.safeargs'
}

android {
    compileSdkVersion 30
    buildToolsVersion "30.0.3"
    // this line here for data binding
    buildFeatures {
        dataBinding true
    }
    
    // Navigation
    implementation "android.arch.navigation:navigation-fragment-ktx:$version_navigation"
    implementation "android.arch.navigation:navigation-ui-ktx:$version_navigation"
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    
    // for safe args
    classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$version_navigation"
    
    
    buildscript {
    ext.kotlin_version = "1.3.72"
    ext {
        version_kotlin = "1.3.72"
        version_core = "1.3.1"
        version_constraint_layout = "2.0.0-rc1"
        version_lifecycle_extensions = "2.2.0"
        version_material = "1.2.0"
        version_navigation = "2.3.0"
    }
```

We got the boring stuff done. Have fun playing

## Errors I ran into
When creating the fragment, the binding didn't work. I simply forgot to wrap the xml of the fragment with <layout> very important to do this to enable databinding. Caused me
a slight headache for forgetting this, but it's good that this happened so I won't forget again
