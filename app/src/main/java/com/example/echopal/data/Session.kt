package com.example.echopal.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "sessions")
data class Session(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val timestamp: Long,
    val scenario: String,
    val transcript: String,
    val analytics: String // JSON or CSV string for MVP; can be expanded later
)
