package com.artesia.mobile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artesia.mobile.data.source.TempleRepository
import com.artesia.mobile.di.Injection
import com.artesia.mobile.ui.temple.DetailTempleViewModel

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

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetailTempleViewModel::class.java) -> {
                DetailTempleViewModel(templeRepository) as T
            }
            else -> throw Throwable("Unknown View Model" + modelClass.name)
        }
    }
}