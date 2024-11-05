package com.geraldsoft.mypruebas.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geraldsoft.mypruebas.ui.data.Movies
import com.geraldsoft.mypruebas.ui.data.MoviesRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    private val repository = MoviesRepository()

    fun onUiReady(){
        viewModelScope.launch {
            state = UiState(loading = true)
            delay(2000)
            state = UiState(loading = false, movie = repository.fetchPopularMovies())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movie: List<Movies> = emptyList()
    )

}