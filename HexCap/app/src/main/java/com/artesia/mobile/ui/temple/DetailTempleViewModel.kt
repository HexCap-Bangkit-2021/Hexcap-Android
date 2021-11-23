package com.artesia.mobile.ui.temple

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.artesia.mobile.data.source.TempleRepository
import com.artesia.mobile.data.source.model.Temple

class DetailTempleViewModel(private val templeRepository: TempleRepository): ViewModel() {
    private lateinit var templeId: String

    fun setCurrentTemple(templeId: String){
        this.templeId = templeId
    }

    fun getDetailTemple(): LiveData<Temple> = templeRepository.getDetailTemple(templeId)

    fun getLoadingStatus(): LiveData<Boolean> = templeRepository.isLoading

}