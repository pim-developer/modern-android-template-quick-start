package com.renamecompanyname.renameappname

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// The Android Application class is the Application-wide entry point.
//
// - It will be created before the MainActivity.kt.
// - The right place set up global state, initialize libraries with order priority
//
// Must be annotated with @HiltAndroidApp to work with Hilt Dependency Injection.
@HiltAndroidApp
class Application : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}