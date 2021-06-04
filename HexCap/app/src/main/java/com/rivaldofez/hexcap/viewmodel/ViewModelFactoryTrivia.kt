package com.rivaldofez.hexcap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rivaldofez.hexcap.data.source.TriviaRepository
import com.rivaldofez.hexcap.di.Injection
import com.rivaldofez.hexcap.ui.temple.DetailTempleViewModel
import com.rivaldofez.hexcap.ui.trivia.TriviaViewModel

class ViewModelFactoryTrivia private constructor(private val triviaRepository: TriviaRepository): ViewModelProvider.NewInstanceFactory(){
    companion object {
        private var instance: ViewModelFactoryTrivia? = null


        fun getInstance(): ViewModelFactoryTrivia =
            instance ?: synchronized(this){
                instance?: ViewModelFactoryTrivia(Injection.provideTriviaRepository()).apply {
                    instance = this
                }
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TriviaViewModel::class.java) -> {
                TriviaViewModel(triviaRepository) as T
            }
            else -> throw Throwable("Unknown View Model" + modelClass.name)
        }
    }
}