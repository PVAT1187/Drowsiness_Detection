package com.example.drowsinessdetection.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.drowsinessdetection.navigation.AppNavigation
import com.example.drowsinessdetection.ui.theme.DrowsinessDetectionTheme
import com.example.drowsinessdetection.metrics.MetricManager
import java.lang.Exception
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            MetricManager.initialize(this)
        } catch (e: Exception) {
            Log.w("Firebase", "Firebase not initialized. Missing google-services.json")
        }

        setContent {
            DrowsinessDetectionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DrowsinessDetectionTheme {
        AppNavigation()
    }
}
