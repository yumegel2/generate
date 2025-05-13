package com.example.echopal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.echopal.ui.HomeScreen
import com.example.echopal.ui.CoachingScreen
import com.example.echopal.ui.ResultsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EchoPalApp()
        }
    }
}

@Composable
fun EchoPalApp() {
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen(navController) }
            composable("coaching") { CoachingScreen(navController) }
            composable("results") { ResultsScreen(navController) }
        }
    }
}
