package com.dnk.hsakmp.feature.auth.domain

class HandleLoginChallengePushUseCase(
    private val repository: LoginChallengeRepository,
) {
    fun handle(payload: LoginChallengePushPayload) {
        repository.savePendingChallenge(payload)
    }
}
