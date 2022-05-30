package com.example.mvvmbasic.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvmbasic.model.User
import com.example.mvvmbasic.repository.UserRepository

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    fun addUser(user: User) = repository.addUser(user)

    fun getUsers() = repository.getUsers()
}