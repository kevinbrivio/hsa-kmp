package com.dnk.hsakmp.feature.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AuthChallengeScreen(
    vm: AuthChallengeViewModel = koinViewModel(),
) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        vm.refreshPendingChallenge()
    }

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Spacer(Modifier.fillMaxWidth().padding(32.dp))

        Text("HSA")

        if (state.hasPendingChallenge) {
            Text("Pending challenge id: ${state.pendingChallengeId}")
        } else {
            Text("No pending challenge")
        }

        Button(onClick = vm::refreshPendingChallenge) {
            Text("Refresh")
        }
    }
}