package com.example.inspireaichat.data

data class SavedConversation(
    val id: Long,
    val title: String,
    val preview: String,
    val messages: List<ChatMessage>
)
