package com.dnk.hsakmp

import android.app.Application
import com.dnk.hsakmp.core.di.KoinInitializer

class HsaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer.start(this)
    }
}
