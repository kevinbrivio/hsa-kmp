package com.dnk.hsakmp.core.di

import com.dnk.hsakmp.feature.auth.di.authModule
import org.koin.core.module.Module

val sharedModules: List<Module> = listOf(
    coreModule,
    authModule,
)
