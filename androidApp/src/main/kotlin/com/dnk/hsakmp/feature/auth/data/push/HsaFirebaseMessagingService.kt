package com.dnk.hsakmp.feature.auth.data.push

import android.util.Log
import com.dnk.hsakmp.feature.auth.domain.HandleLoginChallengePushUseCase
import com.dnk.hsakmp.feature.auth.domain.LoginChallengePayloadParser
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HsaFirebaseMessagingService : FirebaseMessagingService(), KoinComponent {
    private val payloadParser: LoginChallengePayloadParser by inject()
    private val handleLoginChallengePush: HandleLoginChallengePushUseCase by inject()

    override fun onRegistered(installationId: String) {
        super.onRegistered(installationId)
        Log.d(TAG, "FCM registration ready: $installationId")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val data = message.data
        val payload = payloadParser.parse(data)

        if (payload == null) {
            Log.d(TAG, "Ignored unsupported FCM payload: $data")
            return
        }

        handleLoginChallengePush.handle(payload)
        Log.d(TAG, "Received login challenge: ${payload.challengeId}")
    }

    private companion object {
        const val TAG = "HsaFirebaseMessaging"
    }
}
