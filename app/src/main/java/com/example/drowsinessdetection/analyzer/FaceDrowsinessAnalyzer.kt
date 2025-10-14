package com.example.drowsinessdetection.analyzer

import com.example.drowsinessdetection.metrics.TelemetryManager
import com.google.mlkit.vision.face.Face
import javax.inject.Inject

import android.util.Log

internal class FaceDrowsinessAnalyzer
    @Inject
    constructor(
        private val maxHistory: Int,
        private val drowsinessThreshold: Float,
    ) {
        constructor() : this(DEFAULT_MAX_HISTORY, DEFAULT_DROWSINESS_THRESHOLD)

        private val history = ArrayDeque<Boolean>(maxHistory)

        private var lastAlertTime = 0L
        private var alertCooldown = 3000L

        fun isDrowsy(face: Face): Boolean {
            val leftProb = face.leftEyeOpenProbability
            val rightProb = face.rightEyeOpenProbability

            if (leftProb == null || rightProb == null) {
                return false
            }


            val drowsy = leftProb < drowsinessThreshold && rightProb < drowsinessThreshold

            val currentTime = System.currentTimeMillis()
            if (drowsy && currentTime - lastAlertTime > alertCooldown) {
                TelemetryManager.recordDrowsyAlertEvent()
                Log.d("Telemetry", "Drowsy event recorded to OpenTelemetry")
                lastAlertTime = currentTime
            }
            history.addLast(drowsy)
            if (history.size > maxHistory) {
                history.removeFirst()
            }

            return history.size == maxHistory && history.all { it }
        }

        companion object {
            const val DEFAULT_MAX_HISTORY = 3
            const val DEFAULT_DROWSINESS_THRESHOLD = 0.5f
        }
    }
