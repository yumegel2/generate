package com.example.inspireaichat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inspireaichat.ui.ChatScreen
import com.example.inspireaichat.ui.HomeScreen
import com.example.inspireaichat.ui.SavedScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InspireAIApp()
        }
    }
}

@Composable
fun InspireAIApp() {
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen(navController) }
            composable("chat") { ChatScreen(navController) }
            composable("saved") { SavedScreen(navController) }
        }
    }
}
