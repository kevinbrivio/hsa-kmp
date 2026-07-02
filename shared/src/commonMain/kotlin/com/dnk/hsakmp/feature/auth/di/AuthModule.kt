package com.dnk.hsakmp.feature.auth.di

import com.dnk.hsakmp.feature.auth.data.InMemoryLoginChallengeRepository
import com.dnk.hsakmp.feature.auth.domain.GetPendingLoginChallengeUseCase
import com.dnk.hsakmp.feature.auth.domain.HandleLoginChallengePushUseCase
import com.dnk.hsakmp.feature.auth.domain.LoginChallengePayloadParser
import com.dnk.hsakmp.feature.auth.domain.LoginChallengeRepository
import com.dnk.hsakmp.feature.auth.presentation.AuthChallengeViewModel
import org.koin.dsl.module

val authModule = module {
    single { LoginChallengePayloadParser() }
    single<LoginChallengeRepository> { InMemoryLoginChallengeRepository() }
    single { HandleLoginChallengePushUseCase(get()) }
    single { GetPendingLoginChallengeUseCase(get()) }
    factory { AuthChallengeViewModel(get()) }
}
