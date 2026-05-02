package com.example.streetviewgame.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.streetviewgame.GameState
import com.google.maps.android.compose.streetview.StreetView
import com.google.maps.android.compose.streetview.rememberStreetViewCameraPositionState
import com.google.maps.android.ktx.MapsExperimentalFeature
import kotlin.OptIn

@OptIn(MapsExperimentalFeature::class)
@Composable
fun GameScreen(
    gameState: GameState,
    onAnswerSubmit: (String) -> Unit
) {
    val location = gameState.currentLocation
    
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Pontuação: ${gameState.score} / 10",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        // Street View
        Box(modifier = Modifier.weight(1f)) {
            if (location != null) {
                key(location.coordinates) {
                    val cameraPositionState = rememberStreetViewCameraPositionState()
                    
                    StreetView(
                        modifier = Modifier.fillMaxSize(),
                        cameraPositionState = cameraPositionState,
                        streetViewPanoramaOptionsFactory = {
                            com.google.android.gms.maps.StreetViewPanoramaOptions()
                                .position(location.coordinates)
                                .panoramaCamera(com.google.android.gms.maps.model.StreetViewPanoramaCamera.Builder()
                                    .zoom(1f)
                                    .tilt(0f)
                                    .bearing(0f)
                                    .build())
                        }
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Em qual país estamos?",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            
            gameState.options.chunked(2).forEach { rowOptions ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowOptions.forEach { option ->
                        Button(
                            onClick = { onAnswerSubmit(option) },
                            modifier = Modifier.weight(1f).height(50.dp)
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
        }
    }
}
