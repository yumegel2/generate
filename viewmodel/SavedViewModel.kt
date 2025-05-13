package com.example.inspireaichat.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.inspireaichat.data.ChatRepository
import com.example.inspireaichat.data.SavedConversation

class SavedViewModel : ViewModel() {
    private val _savedChats = MutableStateFlow<List<SavedConversation>>(ChatRepository.getSavedConversations())
    val savedChats = _savedChats.asStateFlow()
}
