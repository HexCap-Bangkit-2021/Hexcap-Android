package com.artesia.mobile.data.source.remote.config

import com.artesia.mobile.data.source.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("candis")
    fun getAllTemple(): Call<TempleResponse>

    @GET("trivias")
    fun getAllTrivia(): Call<TriviaResponse>

    @GET("candi/{id}")
    fun getTempleById(
        @Path("id") id: String
    ): Call<TempleDetailResponse>

    @GET("trivia/{id}")
    fun getTriviaById(
        @Path("id") id: String
    ): Call<TriviaDetailResponse>

    @GET("articles")
    fun getAllArticles(): Call<ArticleResponse>

    @GET("article/{category}")
    fun getArticlesByCategory(
        @Path("category") category: String
    ): Call<ArticleResponse>
}