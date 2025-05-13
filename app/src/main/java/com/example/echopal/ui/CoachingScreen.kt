package com.example.echopal.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CoachingScreen(navController: NavController) {
    var isListening by remember { mutableStateOf(false) }
    var transcript by remember { mutableStateOf("") }
    var aiFeedback by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Live Coaching (Prototype)", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = transcript,
            onValueChange = { transcript = it },
            label = { Text("Live Transcript (mock)") },
            modifier = Modifier.fillMaxWidth().height(120.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            isListening = !isListening
            if (isListening) {
                // Simulate live transcription with a mock phrase
                transcript = "Hi, um, I wanted to, like, ask about your project."
                aiFeedback = "Tip: Try reducing filler words like 'um' and 'like' for clarity."
            } else {
                transcript = ""
                aiFeedback = ""
            }
        }) {
            Text(if (isListening) "Stop Listening" else "Start Listening (Mock)")
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (aiFeedback.isNotEmpty()) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(
                    aiFeedback,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate("results") }) {
            Text("End Session & View Results")
        }
    }
}

