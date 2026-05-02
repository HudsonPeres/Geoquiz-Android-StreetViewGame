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
fun ResultScreen(isWin: Boolean, score: Int, onPlayAgain: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val title = if (isWin) "Você Venceu!" else "Você Perdeu!"
        val color = if (isWin) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error

        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = color,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Text(
            text = "Pontuação: $score",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 48.dp)
        )

        Button(
            onClick = onPlayAgain,
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("Voltar ao Início")
        }
    }
}
