package com.example.mvvmbasic.util

import com.example.mvvmbasic.data.FakeDatabase
import com.example.mvvmbasic.repository.UserRepository
import com.example.mvvmbasic.viewmodel.UserViewModelFactory

object InjectorUtil {

    fun provideUsersViewModelFactory(): UserViewModelFactory {
        val userRepository = UserRepository.getInstance(FakeDatabase.getInstance().userDao)
        return UserViewModelFactory(userRepository)
    }
}