package com.example.inspireaichat.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inspireaichat.data.ChatMessage
import com.example.inspireaichat.data.ChatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.inspireaichat.network.OpenAIApiService
import com.example.inspireaichat.network.RetrofitInstance
import com.example.inspireaichat.network.OpenAIRequestBody

class ChatViewModel : ViewModel() {
    private val _chatHistory = MutableStateFlow<List<ChatMessage>>(emptyList())
    val chatHistory = _chatHistory.asStateFlow()

    fun sendMessage(userInput: String) {
        val updated = _chatHistory.value + ChatMessage("user", userInput)
        _chatHistory.value = updated
        getAIResponse(updated)
    }

    fun saveCurrentChat() {
        ChatRepository.saveConversation(
            com.example.inspireaichat.data.SavedConversation(
                id = System.currentTimeMillis(),
                title = "Chat @ ${System.currentTimeMillis()}",
                preview = _chatHistory.value.joinToString { it.content.take(10) },
                messages = _chatHistory.value
            )
        )
    }

    private fun getAIResponse(messages: List<ChatMessage>) {
        viewModelScope.launch {
            try {
                val apiMessages = messages.map { mapOf("role" to it.role, "content" to it.content) }
                val body = OpenAIRequestBody(messages = apiMessages)
                val response = RetrofitInstance.api.chatCompletion(body)
                if (response.isSuccessful) {
                    val aiMessage = response.body()?.choices?.firstOrNull()?.message
                    aiMessage?.let {
                        _chatHistory.value = _chatHistory.value + ChatMessage(it.role, it.content)
                    }
                }
            } catch (e: Exception) {
                // Handle error (show message, etc)
            }
        }
    }
}
