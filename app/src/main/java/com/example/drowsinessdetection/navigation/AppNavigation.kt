package com.example.drowsinessdetection.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.drowsinessdetection.presentation.screens.facedetection.FaceDetectionScreen
import com.example.drowsinessdetection.presentation.screens.home.HomeScreen

internal sealed class Screen(
    val route: String,
) {
    object Home : Screen("home")

    object FaceDetection : Screen("face_detection")
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.FaceDetection.route) {
            FaceDetectionScreen(navController)
        }
    }
}
