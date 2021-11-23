package com.artesia.mobile.data.source

import androidx.lifecycle.LiveData
import com.artesia.mobile.data.source.model.Trivia

interface TriviaDataSource {
    fun getAllTrivia(): LiveData<List<Trivia>>

    fun getDetailTrivia(triviaid: String): LiveData<Trivia>
}