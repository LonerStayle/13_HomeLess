package com.example.a13_homeless.api.api

import com.example.a13_homeless.api.dataholder.User
import com.example.a13_homeless.api.dataholder.UserOverView
import com.example.a13_homeless.api.dataholder.UserRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object GithubApiClient {

    private const val BASE_URL = "https://api.github.com"
    val api: GithubApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GithubApi::class.java)
}

interface GithubApi {

    @GET("/users")
    suspend fun getUserList():List<User>

    @GET("/users/{user}")
    suspend fun getUserOverView(@Path("user") user: String?): UserOverView

    @GET("/users/{user}/repos")
    suspend fun getRepoList(@Path("user") user: String?): List<UserRepo>

    @GET("/users/{user}/starred")
    suspend fun getStarred(@Path("user") user: String?): List<UserRepo>

}