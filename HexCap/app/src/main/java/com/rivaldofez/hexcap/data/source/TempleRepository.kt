package com.rivaldofez.hexcap.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rivaldofez.hexcap.data.source.model.Temple
import com.rivaldofez.hexcap.data.source.remote.RemoteDataSource

class TempleRepository(private val remoteDataSource: RemoteDataSource): TempleDataSource {
    val isLoading = MutableLiveData<Boolean>()

    companion object{
        @Volatile
        private var instance: TempleRepository? = null
        fun getInstance(remoteDataSource: RemoteDataSource): TempleRepository =
            instance ?: synchronized(this){
                instance ?: TempleRepository(remoteDataSource).apply { instance = this }
            }
    }

    override fun getAllTemple(): LiveData<List<Temple>> {
        isLoading.value = true

        val templeResults = MutableLiveData<List<Temple>>()
        remoteDataSource.getAllTemple(object: RemoteDataSource.LoadAllTempleCallback{
            override fun onAllTempleLoaded(templesResponse: List<Temple>) {
                isLoading.value = false
                templeResults.postValue(templesResponse)
            }
        })
        return templeResults
    }

    override fun getDetailTemple(templeId: String): LiveData<Temple> {
        isLoading.value = true

        val detailTempleResult = MutableLiveData<Temple>()

        remoteDataSource.getDetailTemple(templeId = templeId, callback = object: RemoteDataSource.LoadDetailTempleCallback{
            override fun onDetailTempleLoaded(templesResponse: Temple) {
                isLoading.value = false
                detailTempleResult.postValue(templesResponse)
            }
        })

        return detailTempleResult
    }
}