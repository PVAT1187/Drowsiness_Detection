package com.example.drowsinessdetection.metrics

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object MetricManager {
    private var firebaseAnalytics: FirebaseAnalytics? = null

    fun initialize(context: Context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }

    fun recordDrowsyAlertEvent() {
        val bundle = Bundle().apply {
            putString("event_type", "drowsy_alert")
            putLong("timestamp", System.currentTimeMillis())
        }

        firebaseAnalytics?.logEvent("drowsy_alert_detected", bundle)
    }
}