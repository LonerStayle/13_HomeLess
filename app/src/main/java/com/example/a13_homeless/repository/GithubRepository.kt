package com.example.a13_homeless.repository

import com.example.a13_homeless.api.api.GithubApiClient
import com.example.a13_homeless.api.dataholder.User
import com.example.a13_homeless.api.dataholder.UserOverView
import com.example.a13_homeless.api.dataholder.UserRepo

interface DataSource {

    suspend fun getUserList():List<User>

    suspend fun getUserOverView(user: String?): UserOverView

    suspend fun getRepoList(user: String?): List<UserRepo>

    suspend fun getStarred(user: String?): List<UserRepo>

}

class GithubRepository: DataSource {

    override suspend fun getUserList(): List<User> {
        return GithubApiClient.api.getUserList()
    }

    override suspend fun getUserOverView(user: String?): UserOverView {
        return GithubApiClient.api.getUserOverView(user)
    }

    override suspend fun getRepoList(user: String?): List<UserRepo> {
        return GithubApiClient.api.getRepoList(user)
    }

    override suspend fun getStarred(user: String?): List<UserRepo> {
        return GithubApiClient.api.getStarred(user)
    }

}