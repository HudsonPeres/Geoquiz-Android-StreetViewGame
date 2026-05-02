package com.example.streetviewgame

import androidx.lifecycle.ViewModel
import com.example.streetviewgame.data.Location
import com.example.streetviewgame.data.Locations
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class GameState(
    val score: Int = 0,
    val currentLocation: Location? = null,
    val options: List<String> = emptyList(),
    val isGameOver: Boolean = false,
    val isWin: Boolean = false,
    val playedLocations: Set<Location> = emptySet()
)

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameState())
    val uiState: StateFlow<GameState> = _uiState.asStateFlow()

    init {
        startNewGame()
    }

    fun startNewGame() {
        val firstLocation = Locations.gameLocations.random()
        _uiState.value = GameState(
            score = 0,
            currentLocation = firstLocation,
            options = generateOptions(firstLocation.country),
            playedLocations = setOf(firstLocation)
        )
    }

    private fun generateOptions(correctCountry: String): List<String> {
        val wrongOptions = Locations.allCountries
            .filter { it != correctCountry }
            .shuffled()
            .take(3)
        return (wrongOptions + correctCountry).shuffled()
    }

    fun submitAnswer(country: String) {
        val currentState = _uiState.value
        val correctCountry = currentState.currentLocation?.country
        
        if (country == correctCountry) {
            val newScore = currentState.score + 1
            if (newScore >= 10) {
                _uiState.update { it.copy(score = newScore, isGameOver = true, isWin = true) }
            } else {
                val availableLocations = Locations.gameLocations.filter { it !in currentState.playedLocations }
                val nextLocation = if (availableLocations.isNotEmpty()) {
                    availableLocations.random()
                } else {
                    Locations.gameLocations.random()
                }
                
                _uiState.update { 
                    it.copy(
                        score = newScore,
                        currentLocation = nextLocation,
                        options = generateOptions(nextLocation.country),
                        playedLocations = it.playedLocations + nextLocation
                    )
                }
            }
        } else {
            _uiState.update { it.copy(isGameOver = true, isWin = false) }
        }
    }
}
