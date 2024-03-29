package com.rivaldofez.hexcap.ui.trivia

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rivaldofez.hexcap.data.source.TriviaRepository
import com.rivaldofez.hexcap.data.source.model.Trivia

class TriviaViewModel(private val triviaRepository: TriviaRepository): ViewModel() {
    private lateinit var triviaId: String

    fun setCurrentTrivia(triviaId: String){
        this.triviaId = triviaId
    }

    fun getDetailTrivia(): LiveData<Trivia> = triviaRepository.getDetailTrivia(triviaId)

    fun getLoadingStatus(): LiveData<Boolean> = triviaRepository.isLoading

}