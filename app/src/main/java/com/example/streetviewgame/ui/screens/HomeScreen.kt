package com.example.streetviewgame.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onStartGame: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "GeoQuiz - API Maps SDK Android",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text(
            text = "Descubra o país!\n10 acertos para vencer.\n1 erro para perder.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 48.dp)
        )
        Button(
            onClick = onStartGame,
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("Começar Jogo")
        }
    }
}
