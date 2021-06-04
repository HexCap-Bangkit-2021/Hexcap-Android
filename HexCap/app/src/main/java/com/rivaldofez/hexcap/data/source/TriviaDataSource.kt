package com.rivaldofez.hexcap.data.source

import androidx.lifecycle.LiveData
import com.rivaldofez.hexcap.data.source.model.Trivia

interface TriviaDataSource {
    fun getAllTrivia(): LiveData<List<Trivia>>

    fun getDetailTrivia(triviaid: String): LiveData<Trivia>
}