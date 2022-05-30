package com.example.mvvmbasic.data

class FakeDatabase private constructor(){

    var userDao = UserDao()
        private set

    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: FakeDatabase().also {
                instance = it
            }
        }
    }
}