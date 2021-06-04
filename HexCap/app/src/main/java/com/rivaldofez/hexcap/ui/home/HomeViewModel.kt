package com.rivaldofez.hexcap.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rivaldofez.hexcap.data.source.TempleRepository
import com.rivaldofez.hexcap.data.source.model.Temple

class HomeViewModel(private val templeRepository: TempleRepository): ViewModel() {
    fun getAllTemple(): LiveData<List<Temple>> = templeRepository.getAllTemple()

    fun getLoadingStatus(): LiveData<Boolean> = templeRepository.isLoading
}