package com.dnk.hsakmp.feature.auth.data

import com.dnk.hsakmp.feature.auth.domain.LoginChallengePushPayload
import com.dnk.hsakmp.feature.auth.domain.LoginChallengeRepository

class InMemoryLoginChallengeRepository : LoginChallengeRepository {
    private var pendingChallenge: LoginChallengePushPayload? = null

    override fun savePendingChallenge(payload: LoginChallengePushPayload) {
        pendingChallenge = payload
    }

    override fun getPendingChallenge(): LoginChallengePushPayload? = pendingChallenge
}
