package com.dnk.hsakmp.feature.auth.presentation

import androidx.lifecycle.ViewModel
import com.dnk.hsakmp.feature.auth.domain.GetPendingLoginChallengeUseCase

class AuthChallengeViewModel(
    private val getPendingLoginChallenge: GetPendingLoginChallengeUseCase,
) : ViewModel() {
    var uiState: AuthChallengeUiState = AuthChallengeUiState()
        private set

    fun refreshPendingChallenge() {
        val pendingChallenge = getPendingLoginChallenge.get()
        uiState = AuthChallengeUiState(
            pendingChallengeId = pendingChallenge?.challengeId,
        )
    }
}
