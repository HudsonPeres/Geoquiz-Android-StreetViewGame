package com.example.streetviewgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.streetviewgame.ui.screens.GameScreen
import com.example.streetviewgame.ui.screens.HomeScreen
import com.example.streetviewgame.ui.screens.ResultScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StreetViewApp()
                }
            }
        }
    }
}

@Composable
fun StreetViewApp() {
    val navController = rememberNavController()
    val viewModel: GameViewModel = viewModel()
    val gameState by viewModel.uiState.collectAsState()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onStartGame = {
                    viewModel.startNewGame()
                    navController.navigate("game") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }
        
        composable("game") {
            if (gameState.isGameOver) {
                androidx.compose.runtime.LaunchedEffect(Unit) {
                    navController.navigate("result") {
                        popUpTo("game") { inclusive = true }
                    }
                }
            }
            
            GameScreen(
                gameState = gameState,
                onAnswerSubmit = { answer ->
                    viewModel.submitAnswer(answer)
                }
            )
        }
        
        composable("result") {
            ResultScreen(
                isWin = gameState.isWin,
                score = gameState.score,
                onPlayAgain = {
                    navController.navigate("home") {
                        popUpTo("result") { inclusive = true }
                    }
                }
            )
        }
    }
}
