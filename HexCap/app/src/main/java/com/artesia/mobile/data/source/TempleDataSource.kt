package com.artesia.mobile.data.source

import androidx.lifecycle.LiveData
import com.artesia.mobile.data.source.model.Temple

interface TempleDataSource {
    fun getAllTemple(): LiveData<List<Temple>>

    fun getDetailTemple(templeId: String): LiveData<Temple>
}