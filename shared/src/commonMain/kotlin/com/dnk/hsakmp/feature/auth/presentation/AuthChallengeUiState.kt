package com.dnk.hsakmp.feature.auth.presentation

data class AuthChallengeUiState(
    val pendingChallengeId: String? = null,
) {
    val hasPendingChallenge: Boolean
        get() = pendingChallengeId != null
}
