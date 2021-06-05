package com.rivaldofez.hexcap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rivaldofez.hexcap.data.source.TempleRepository
import com.rivaldofez.hexcap.di.Injection
import com.rivaldofez.hexcap.ui.home.HomeViewModel

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