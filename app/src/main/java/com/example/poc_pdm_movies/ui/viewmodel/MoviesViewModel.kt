package com.example.poc_pdm_movies.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poc_pdm_movies.data.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<MoviesUiState>(MoviesUiState.Loading)
    val uiState: StateFlow<MoviesUiState> = _uiState.asStateFlow()

    init {
        loadMovies()
    }

    fun loadMovies() {
        viewModelScope.launch {
            _uiState.value = MoviesUiState.Loading
            try {
                val response = RetrofitClient.instance.getPopularMovies()
                _uiState.value = MoviesUiState.Success(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.value = MoviesUiState.Error("Falha ao carregar filmes: ${e.message}")
            }
        }
    }
}