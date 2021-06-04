package com.rivaldofez.hexcap.data.source

import androidx.lifecycle.LiveData
import com.rivaldofez.hexcap.data.source.model.Temple

interface TempleDataSource {
    fun getAllTemple(): LiveData<List<Temple>>

    fun getDetailTemple(templeId: String): LiveData<Temple>
}