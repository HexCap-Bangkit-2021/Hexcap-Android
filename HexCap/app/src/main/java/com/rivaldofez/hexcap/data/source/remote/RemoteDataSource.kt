package com.rivaldofez.hexcap.data.source.remote

import android.util.Log
import com.rivaldofez.hexcap.data.source.model.*
import com.rivaldofez.hexcap.data.source.remote.config.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource()
            }
    }

    fun getAllTemple(callback: LoadAllTempleCallback){
        val client = ApiConfig.getApiService().getAllTemple()
        client.enqueue(object: Callback<TempleResponse>{
            override fun onResponse(
                call: Call<TempleResponse>,
                response: Response<TempleResponse>
            ) {
                response.body()?.data?.let { callback.onAllTempleLoaded(it) }
            }

            override fun onFailure(call: Call<TempleResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "fail at getAllTemple because: ${t.message}")
            }
        })
    }

    fun getAllTrivia(callback: LoadAllTriviaCallback){
        val client = ApiConfig.getApiService().getAllTrivia()
        client.enqueue(object: Callback<TriviaResponse>{
            override fun onResponse(
                call: Call<TriviaResponse>,
                response: Response<TriviaResponse>
            ) {
                response.body()?.data?.let { callback.onAllTriviaLoaded(it) }
            }

            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "fail at getAllTrivia because: ${t.message}")
            }
        })
    }

    fun getDetailTemple(callback: LoadDetailTempleCallback, templeId: String){
        val client = ApiConfig.getApiService().getTempleById(templeId)
        client.enqueue(object: Callback<TempleDetailResponse>{
            override fun onResponse(
                call: Call<TempleDetailResponse>,
                response: Response<TempleDetailResponse>
            ) {
                response.body()?.data?.let { callback.onDetailTempleLoaded(it) }
            }

            override fun onFailure(call: Call<TempleDetailResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "fail at getEDetailTemple because: ${t.message}")
            }
        })
    }

    fun getDetailTrivia(callback: LoadDetailTriviaCallback, triviaId: String){
        val client = ApiConfig.getApiService().getTriviaById(triviaId)
        client.enqueue(object: Callback<TriviaDetailResponse>{
            override fun onResponse(
                call: Call<TriviaDetailResponse>,
                response: Response<TriviaDetailResponse>
            ) {
                response.body()?.data?.let { callback.onAllTriviaLoaded(it) }
            }

            override fun onFailure(call: Call<TriviaDetailResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "fail at getDetailTrivia because: ${t.message}")
            }
        })
    }

    interface LoadAllTempleCallback{
        fun onAllTempleLoaded(templesResponse: List<Temple>)
    }

    interface LoadAllTriviaCallback{
        fun onAllTriviaLoaded(triviaResponse: List<Trivia>)
    }

    interface LoadDetailTempleCallback{
        fun onDetailTempleLoaded(templesResponse: Temple)
    }

    interface LoadDetailTriviaCallback{
        fun onAllTriviaLoaded(triviaResponse: Trivia)
    }
}