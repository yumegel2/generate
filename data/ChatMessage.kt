package com.example.inspireaichat.data

data class ChatMessage(
    val role: String, // "user" or "assistant"
    val content: String
)
