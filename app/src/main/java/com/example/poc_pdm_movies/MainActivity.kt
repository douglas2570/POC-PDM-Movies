package com.example.poc_pdm_movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.poc_pdm_movies.ui.navigation.AppNavigation
import com.example.poc_pdm_movies.ui.theme.POCPDMMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POCPDMMoviesTheme() {
                AppNavigation()
            }
        }
    }
}