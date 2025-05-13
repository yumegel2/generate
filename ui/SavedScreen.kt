package com.example.inspireaichat.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inspireaichat.viewmodel.SavedViewModel

@Composable
fun SavedScreen(navController: NavController, viewModel: SavedViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val savedChats by viewModel.savedChats.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Saved Conversations", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(savedChats.size) { idx ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Text(savedChats[idx].title)
                    Text(savedChats[idx].preview)
                }
            }
        }
    }
}
