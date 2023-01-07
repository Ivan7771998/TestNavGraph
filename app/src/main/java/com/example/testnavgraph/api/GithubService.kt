package com.example.testnavgraph.api

import com.example.testnavgraph.data.RepositoryModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{user}/repos")
    suspend fun getUserRepos(@Path("user") user: String) : Response<List<RepositoryModel>>

    companion object {
        var retrofitService: GithubService? = null
        fun getInstance() : GithubService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(GithubService::class.java)
            }
            return retrofitService!!
        }

    }
}