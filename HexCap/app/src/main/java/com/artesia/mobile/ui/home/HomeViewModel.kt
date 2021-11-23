package com.artesia.mobile.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.artesia.mobile.data.source.TempleRepository
import com.artesia.mobile.data.source.model.Temple

class HomeViewModel(private val templeRepository: TempleRepository): ViewModel() {
    fun getAllTemple(): LiveData<List<Temple>> = templeRepository.getAllTemple()

    fun getLoadingStatus(): LiveData<Boolean> = templeRepository.isLoading
}