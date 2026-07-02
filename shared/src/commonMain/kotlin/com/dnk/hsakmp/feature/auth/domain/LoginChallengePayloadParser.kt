package com.dnk.hsakmp.feature.auth.domain

class LoginChallengePayloadParser {
    fun parse(data: Map<String, String>): LoginChallengePushPayload? {
        val type = data[TYPE_KEY]
        val challengeId = data[CHALLENGE_ID_KEY]

        if (type != LOGIN_CHALLENGE_TYPE || challengeId.isNullOrBlank()) {
            return null
        }

        return LoginChallengePushPayload(challengeId = challengeId)
    }

    private companion object {
        const val TYPE_KEY = "type"
        const val CHALLENGE_ID_KEY = "challengeId"
        const val LOGIN_CHALLENGE_TYPE = "login_challenge"
    }
}
