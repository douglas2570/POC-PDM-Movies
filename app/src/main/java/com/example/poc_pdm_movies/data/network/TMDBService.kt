package com.example.poc_pdm_movies.data.network

import com.example.poc_pdm_movies.data.model.Movie
import com.example.poc_pdm_movies.data.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBService {

    companion object {
        const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlODFjMWEyMGNhNTQ4M2ZkOGI2OGNjNDRiNmJmMmVlOSIsIm5iZiI6MTc2ODM5MTEwNC4zOTIsInN1YiI6IjY5Njc4MWMwNDcwNzJjOWE2M2NhY2U1MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Fuv6W0exTMXbR12DoeQk86s1tD-4iCefgMARTfNa3Qc"
    }

    @Headers(
        "Authorization: Bearer $TOKEN",
        "accept: application/json"
    )
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): MoviesResponse

    @Headers(
        "Authorization: Bearer $TOKEN",
        "accept: application/json"
    )
    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int,
        @Query("language") language: String = "en-US"
    ): Movie
}