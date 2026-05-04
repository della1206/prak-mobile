package com.example.della_apps.Message

data class MessageModel(
    val senderName: String,
    val messageText: String,
    val avatarRes: Int // Menggunakan Int untuk ID resource drawable
)