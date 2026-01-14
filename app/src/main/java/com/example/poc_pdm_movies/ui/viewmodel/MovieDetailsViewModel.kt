package com.example.poc_pdm_movies.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.poc_pdm_movies.data.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val movieId: Int) : ViewModel() {

    private val _uiState = MutableStateFlow<MovieDetailsUiState>(MovieDetailsUiState.Loading)
    val uiState: StateFlow<MovieDetailsUiState> = _uiState.asStateFlow()

    init {
        loadMovieDetails()
    }

    private fun loadMovieDetails() {
        viewModelScope.launch {
            _uiState.value = MovieDetailsUiState.Loading
            try {
                val movie = RetrofitClient.instance.getMovieDetails(movieId)
                _uiState.value = MovieDetailsUiState.Success(movie)
            } catch (e: Exception) {
                _uiState.value = MovieDetailsUiState.Error("Erro ao carregar detalhes: ${e.message}")
            }
        }
    }

    class Factory(private val movieId: Int) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MovieDetailsViewModel::class.java)) {
                return MovieDetailsViewModel(movieId) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}