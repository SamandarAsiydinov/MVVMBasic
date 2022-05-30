package com.example.mvvmbasic.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmbasic.model.User

class UserDao {
    private val userList = mutableListOf<User>()
    private val users = MutableLiveData<List<User>>()

    init {
        users.value = userList
    }
    fun addUser(user: User) {
        userList.add(user)
        users.value = userList
    }
    fun getUsers() = users as LiveData<List<User>>
}