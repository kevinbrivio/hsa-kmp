package com.dnk.hsakmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.dnk.hsakmp.feature.auth.presentation.AuthChallengeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        AuthChallengeScreen()
    }
}