package com.example.inspireaichat.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inspireaichat.viewmodel.ChatViewModel

@Composable
fun ChatScreen(navController: NavController, viewModel: ChatViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val chatHistory by viewModel.chatHistory.collectAsState()
    var userInput by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(chatHistory.size) { idx ->
                Text(chatHistory[idx].role + ": " + chatHistory[idx].content)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        OutlinedTextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Type your message...") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Button(onClick = {
                viewModel.sendMessage(userInput)
                userInput = ""
            }) { Text("Send") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.saveCurrentChat() }) { Text("Save Chat") }
        }
    }
}
