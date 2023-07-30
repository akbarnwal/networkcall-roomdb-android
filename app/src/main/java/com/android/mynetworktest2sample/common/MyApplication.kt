package com.android.mynetworktest2sample.common

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()
    }

}