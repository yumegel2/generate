package com.example.inspireaichat.network

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.Response

interface OpenAIApiService {
    @Headers("Content-Type: application/json")
    @POST("v1/chat/completions")
    suspend fun chatCompletion(@Body body: OpenAIRequestBody): Response<OpenAIResponse>
}

// --- Data classes for request/response ---
data class OpenAIRequestBody(
    val model: String = "gpt-3.5-turbo",
    val messages: List<Map<String, String>>
)

data class OpenAIResponse(
    val choices: List<Choice>
) {
    data class Choice(val message: Message) {
        data class Message(val role: String, val content: String)
    }
}
