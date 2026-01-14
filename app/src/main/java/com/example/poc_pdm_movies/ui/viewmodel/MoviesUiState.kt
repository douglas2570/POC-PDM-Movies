package com.example.poc_pdm_movies.ui.viewmodel

import com.example.poc_pdm_movies.data.model.Movie

sealed interface MoviesUiState {
    object Loading : MoviesUiState
    data class Success(val movies: List<Movie>) : MoviesUiState
    data class Error(val message: String) : MoviesUiState
}

// Define os estados para os detalhes do filme
sealed interface MovieDetailsUiState {
    object Loading : MovieDetailsUiState
    data class Success(val movie: Movie) : MovieDetailsUiState
    data class Error(val message: String) : MovieDetailsUiState
}