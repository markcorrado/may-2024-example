package com.example.may2024example.networking

import com.example.may2024example.networking.model.SearchResult
import retrofit2.Response
import retrofit2.http.GET

interface GithubService {
    @GET("/search/repositories?q=stars:>0&per_page=100")
    suspend fun getMostStarredGithubRepos(): Response<SearchResult>
}