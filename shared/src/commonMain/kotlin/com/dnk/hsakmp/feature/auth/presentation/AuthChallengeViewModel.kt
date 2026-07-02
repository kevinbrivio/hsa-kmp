package com.dnk.hsakmp.feature.auth.presentation

import androidx.lifecycle.ViewModel
import com.dnk.hsakmp.feature.auth.domain.GetPendingLoginChallengeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthChallengeViewModel(
    private val getPendingLoginChallenge: GetPendingLoginChallengeUseCase,
) : ViewModel() {
    private var _uiState = MutableStateFlow(AuthChallengeUiState())
    val uiState: StateFlow<AuthChallengeUiState> = _uiState.asStateFlow()

    fun refreshPendingChallenge() {
        val pendingChallenge = getPendingLoginChallenge.get()
        _uiState.value = AuthChallengeUiState(
            pendingChallengeId = pendingChallenge?.challengeId,
        )
    }
}
