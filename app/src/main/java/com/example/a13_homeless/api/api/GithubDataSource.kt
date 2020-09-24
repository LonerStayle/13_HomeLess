package com.example.a13_homeless.api.api

import com.example.a13_homeless.api.dataholder.User
import com.example.a13_homeless.api.dataholder.UserOverView
import com.example.a13_homeless.api.dataholder.UserRepo
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubDataSource {

    suspend fun getUserList():List<User>
    
    suspend fun getUserOverView(user: String?): UserOverView

    suspend fun getRepoList(user: String?): List<UserRepo>

    suspend fun getStarred(user: String?): List<UserRepo>

}