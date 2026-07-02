package com.dnk.hsakmp.feature.auth.data.push

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class HsaFirebaseMessagingService : FirebaseMessagingService() {
    override fun onRegistered(installationId: String) {
        super.onRegistered(installationId)
        Log.d(TAG, "FCM registration ready: $installationId")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val data = message.data
        val type = data["type"]
        val challengeId = data["challengeId"]

        if (type != LOGIN_CHALLENGE_TYPE || challengeId.isNullOrBlank()) {
            Log.d(TAG, "Ignored unsupported FCM payload: $data")
            return
        }

        Log.d(TAG, "Received login challenge: $challengeId")
    }

    private companion object {
        const val TAG = "HsaFirebaseMessaging"
        const val LOGIN_CHALLENGE_TYPE = "login_challenge"
    }
}
