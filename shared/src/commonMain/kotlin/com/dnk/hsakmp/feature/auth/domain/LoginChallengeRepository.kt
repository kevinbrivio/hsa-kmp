package com.dnk.hsakmp.feature.auth.domain

interface LoginChallengeRepository {
    fun savePendingChallenge(payload: LoginChallengePushPayload)

    fun getPendingChallenge(): LoginChallengePushPayload?
}
