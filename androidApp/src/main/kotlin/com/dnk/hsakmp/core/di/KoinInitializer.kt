package com.dnk.hsakmp.core.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

object KoinInitializer {
    fun start(application: Application) {
        startKoin {
            androidLogger()
            androidContext(application)
            modules(sharedModules)
        }
    }
}
