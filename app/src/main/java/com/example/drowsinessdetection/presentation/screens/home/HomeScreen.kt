package com.example.drowsinessdetection.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.drowsinessdetection.navigation.Screen
import com.example.drowsinessdetection.presentation.common.components.ImageCard
import com.example.drowsinessdetection.R as R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                    ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                    }
                },
                title = { Text(text = stringResource(R.string.app_name)) },
            )
        },
        containerColor = MaterialTheme.colorScheme.primary,
        content = {
            LazyColumn(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 12.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                contentPadding = it,
            ) {
                item {
                    ImageCard(
                        title = stringResource(R.string.face_detection_title),
                        description = stringResource(R.string.face_detection_description),
                        imageUrl = stringResource(R.string.face_detection_url),
                        onCardClick = { navController.navigate(Screen.FaceDetection.route) },
                    )
                }
            }
        }
    )
}
