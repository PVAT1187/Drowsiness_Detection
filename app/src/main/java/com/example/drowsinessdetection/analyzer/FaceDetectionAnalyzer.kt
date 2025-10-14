package com.example.drowsinessdetection.analyzer

import android.annotation.SuppressLint
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.Face
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions

@SuppressLint("UnsafeOptInUsageError")
class FaceDetectionAnalyzer(
    private val onFaceDetected: (faces: MutableList<Face>, drowsyFaces: List<Int>, width: Int, height: Int) -> Unit,
) : ImageAnalysis.Analyzer {
    private val options =
        FaceDetectorOptions
            .Builder()
            .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
            .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
            .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
            .setContourMode(FaceDetectorOptions.CONTOUR_MODE_ALL)
            .enableTracking()
            .build()

    private val drowsinessMap: HashMap<Int, FaceDrowsinessAnalyzer> = HashMap()

    private val faceDetector = FaceDetection.getClient(options)

    override fun analyze(imageProxy: ImageProxy) {
        imageProxy.image?.let {
            val imageValue = InputImage.fromMediaImage(it, imageProxy.imageInfo.rotationDegrees)
            val drowsyFaces: MutableList<Int> = mutableListOf()
            faceDetector
                .process(imageValue)
                .addOnSuccessListener { faces ->
                    faces.forEach { face ->
                        val trackingId = face.trackingId ?: return@forEach
                        drowsinessMap
                            .getOrPut(trackingId, { FaceDrowsinessAnalyzer() })
                            .let { drowsinessAnalyzer ->
                                if (drowsinessAnalyzer.isDrowsy(face)) {
                                    drowsyFaces.add(trackingId)
                                }
                            }
                    }
                    onFaceDetected(faces, drowsyFaces, imageProxy.width, imageProxy.height)
                }.addOnCompleteListener {
                    imageProxy.close()
                }
        }
    }
}
