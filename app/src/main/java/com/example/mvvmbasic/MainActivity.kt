package com.example.mvvmbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmbasic.databinding.ActivityMainBinding
import com.example.mvvmbasic.model.User
import com.example.mvvmbasic.util.InjectorUtil
import com.example.mvvmbasic.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

    }
    private fun initViews() {
        val factory = InjectorUtil.provideUsersViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]

        viewModel.getUsers().observe(this) { userList ->
            val stringBuilder = StringBuilder()
            userList.forEach { user ->
                stringBuilder.append("$user\n\n")
            }
            binding.textView.text = stringBuilder.toString()
        }
        binding.btnAdd.setOnClickListener {
            val title: String = binding.editTitle.text.toString().trim()
            val desc: String = binding.editDesc.text.toString().trim()
            val user = User(title, desc)
            viewModel.addUser(user)
            binding.editDesc.text?.clear()
            binding.editTitle.text?.clear()
        }
    }
}