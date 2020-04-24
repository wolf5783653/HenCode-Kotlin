package com.example.core

import android.app.Application
import android.content.Context

class BaseApplication : Application() {
    companion object {
         lateinit var application: Context
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}