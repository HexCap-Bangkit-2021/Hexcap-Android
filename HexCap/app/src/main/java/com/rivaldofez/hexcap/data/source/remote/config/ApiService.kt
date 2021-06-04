package com.rivaldofez.hexcap.data.source.remote.config

import com.rivaldofez.hexcap.data.source.model.TempleDetailResponse
import com.rivaldofez.hexcap.data.source.model.TempleResponse
import com.rivaldofez.hexcap.data.source.model.TriviaDetailResponse
import com.rivaldofez.hexcap.data.source.model.TriviaResponse
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
}