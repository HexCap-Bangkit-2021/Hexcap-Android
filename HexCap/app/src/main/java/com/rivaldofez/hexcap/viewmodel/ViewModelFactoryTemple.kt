package com.rivaldofez.hexcap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rivaldofez.hexcap.data.source.TempleRepository
import com.rivaldofez.hexcap.di.Injection
import com.rivaldofez.hexcap.ui.home.HomeViewModel
import com.rivaldofez.hexcap.ui.temple.DetailTempleViewModel

class ViewModelFactoryTemple private constructor(private val templeRepository: TempleRepository): ViewModelProvider.NewInstanceFactory(){
    companion object {
        private var instance: ViewModelFactoryTemple? = null

        fun getInstance(): ViewModelFactoryTemple =
            instance ?: synchronized(this){
                instance?: ViewModelFactoryTemple(Injection.provideTempleRepository()).apply {
                    instance = this
                }
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetailTempleViewModel::class.java) -> {
                DetailTempleViewModel(templeRepository) as T
            }
            else -> throw Throwable("Unknown View Model" + modelClass.name)
        }
    }
}