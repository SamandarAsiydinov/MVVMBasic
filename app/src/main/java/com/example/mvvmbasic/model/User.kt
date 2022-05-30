package com.example.mvvmbasic.model

data class User(
    val title: String,
    val description: String
) {
    override fun toString(): String {
        return "User -> $title, $description"
    }
}
