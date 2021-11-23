package com.artesia.mobile.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.artesia.mobile.data.source.model.Trivia
import com.artesia.mobile.data.source.remote.RemoteDataSource

class TriviaRepository(private val remoteDataSource: RemoteDataSource): TriviaDataSource {
    val isLoading = MutableLiveData<Boolean>()

    companion object{
        @Volatile
        private var instance: TriviaRepository? = null
        fun getInstance(remoteDataSource: RemoteDataSource): TriviaRepository =
            instance ?: synchronized(this){
                instance ?: TriviaRepository(remoteDataSource).apply { instance = this }
            }
    }

    override fun getAllTrivia(): LiveData<List<Trivia>> {
        isLoading.value = true

        val triviaResults = MutableLiveData<List<Trivia>>()
        remoteDataSource.getAllTrivia(object: RemoteDataSource.LoadAllTriviaCallback{
            override fun onAllTriviaLoaded(triviaResponse: List<Trivia>) {
                isLoading.value = false
                triviaResults.postValue(triviaResponse)
            }
        })
        return triviaResults
    }

    override fun getDetailTrivia(triviaid: String): LiveData<Trivia> {
        isLoading.value = true

        val detailTrivia = MutableLiveData<Trivia>()

        remoteDataSource.getDetailTrivia(triviaId = triviaid, callback = object: RemoteDataSource.LoadDetailTriviaCallback{
            override fun onAllTriviaLoaded(triviaResponse: Trivia) {
                isLoading.value = false
                detailTrivia.postValue(triviaResponse)
            }
        })
        return detailTrivia
    }
}