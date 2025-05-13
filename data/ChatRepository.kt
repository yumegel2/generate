package com.example.inspireaichat.data

import androidx.compose.runtime.mutableStateListOf
import com.example.inspireaichat.data.ChatMessage
import com.example.inspireaichat.data.SavedConversation

object ChatRepository {
    private val savedChats = mutableStateListOf<SavedConversation>()

    fun saveConversation(conversation: SavedConversation) {
        savedChats.add(conversation)
    }

    fun getSavedConversations(): List<SavedConversation> = savedChats
}
