package com.artesia.mobile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artesia.mobile.data.source.TempleRepository
import com.artesia.mobile.di.Injection
import com.artesia.mobile.ui.home.HomeViewModel

class ViewModelFactoryHome private constructor(private val templeRepository: TempleRepository): ViewModelProvider.NewInstanceFactory(){
    companion object {
        private var instance: ViewModelFactoryHome? = null

        fun getInstance(): ViewModelFactoryHome =
            instance ?: synchronized(this){
                instance?: ViewModelFactoryHome(Injection.provideTempleRepository()).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(templeRepository) as T
            }
            else -> throw Throwable("Unknown View Model" + modelClass.name)
        }
    }
}