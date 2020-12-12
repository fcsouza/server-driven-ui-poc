package com.example.mobileapp

import android.app.Application
import com.example.mobileapp.mobile.BeagleSetup

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        BeagleSetup().init(this)
    }
}