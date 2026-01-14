package com.example.poc_pdm_movies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.poc_pdm_movies.ui.screens.MovieDetailsScreen
import com.example.poc_pdm_movies.ui.screens.MoviesScreen
import com.example.poc_pdm_movies.ui.viewmodel.MovieDetailsViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            MoviesScreen(navController = navController)
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->

            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0

            val viewModel: MovieDetailsViewModel = viewModel(
                factory = MovieDetailsViewModel.Factory(movieId)
            )

            MovieDetailsScreen(navController = navController, viewModel = viewModel)
        }
    }
}