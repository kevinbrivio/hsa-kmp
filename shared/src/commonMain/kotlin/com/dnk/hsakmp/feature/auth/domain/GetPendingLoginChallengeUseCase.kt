package com.dnk.hsakmp.feature.auth.domain

class GetPendingLoginChallengeUseCase(
    private val repository: LoginChallengeRepository,
) {
    fun get(): LoginChallengePushPayload? = repository.getPendingChallenge()
}
