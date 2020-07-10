package com.example.a13_homeless.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubApiClient {

    private const val BASE_URL = "https://api.github.com/"
    val api:GithubApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GithubApi::class.java)
}

interface GithubApi{


}