package com.artesia.mobile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artesia.mobile.data.source.TriviaRepository
import com.artesia.mobile.di.Injection
import com.artesia.mobile.ui.trivia.TriviaViewModel

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

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TriviaViewModel::class.java) -> {
                TriviaViewModel(triviaRepository) as T
            }
            else -> throw Throwable("Unknown View Model" + modelClass.name)
        }
    }
}