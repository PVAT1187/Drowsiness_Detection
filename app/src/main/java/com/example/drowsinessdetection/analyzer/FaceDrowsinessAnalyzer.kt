package com.example.drowsinessdetection.analyzer

import com.google.mlkit.vision.face.Face
import javax.inject.Inject

internal class FaceDrowsinessAnalyzer
    @Inject
    constructor(
        private val maxHistory: Int,
        private val drowsinessThreshold: Float,
    ) {
        constructor() : this(DEFAULT_MAX_HISTORY, DEFAULT_DROWSINESS_THRESHOLD)

        private val history = ArrayDeque<Boolean>(maxHistory)

        fun isDrowsy(face: Face): Boolean {
            val leftProb = face.leftEyeOpenProbability
            val rightProb = face.rightEyeOpenProbability

            if (leftProb == null || rightProb == null) {
                return false
            }

            val drowsy = leftProb < drowsinessThreshold && rightProb < drowsinessThreshold
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
