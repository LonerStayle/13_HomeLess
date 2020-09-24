package com.example.a13_homeless.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a13_homeless.api.repository.GithubRepository


class UserViewModelFactory (private val githubRepository: GithubRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)){

            @Suppress("UNCHECKED_CAST")
            return UserViewModel(githubRepository) as T
        }
        throw IllegalAccessException("Unknown ViewModel")
    }
}