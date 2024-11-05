package com.geraldsoft.mypruebas.ui.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geraldsoft.mypruebas.ui.data.Movies
import com.geraldsoft.mypruebas.ui.data.MoviesRepository
import kotlinx.coroutines.launch

class DetailViewModel(private val id: Int): ViewModel() {

    val moviesRepository = MoviesRepository()

    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(loading = false, movies = moviesRepository.findMovieById(id))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movies: Movies? = null
    )
}
