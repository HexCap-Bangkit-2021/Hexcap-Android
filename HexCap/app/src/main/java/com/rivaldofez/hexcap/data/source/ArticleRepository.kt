package com.rivaldofez.hexcap.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rivaldofez.hexcap.data.source.model.Article
import com.rivaldofez.hexcap.data.source.remote.RemoteDataSource
import java.util.*

class ArticleRepository(private val remoteDataSource: RemoteDataSource): ArticleDataSource {
    val isLoading = MutableLiveData<Boolean>()

    companion object{
        @Volatile
        private var instance: ArticleRepository? = null
        fun getInstance(remoteDataSource: RemoteDataSource): ArticleRepository =
            instance ?: synchronized(this){
                instance ?: ArticleRepository(remoteDataSource).apply { instance = this }
            }
    }

    override fun getAllArticles(): LiveData<List<Article>> {
        isLoading.value = true

        val articleResults = MutableLiveData<List<Article>>()
        remoteDataSource.getAllArticle(object : RemoteDataSource.LoadAllArticleCallback{
            override fun onAllArticleLoaded(articleResponse: List<Article>) {
                articleResults.postValue(articleResponse)
            }
        })
        return articleResults
    }

    override fun getArticleCategory(category: String): LiveData<List<Article>> {
        isLoading.value = true

        val articleResults = MutableLiveData<List<Article>>()
        remoteDataSource.getArticleByCategory(category = category, callback = object: RemoteDataSource.LoadArticleByCategoryCallback{
            override fun onArticleCategory(articleResponse: List<Article>) {
                articleResults.postValue(articleResponse)
            }
        })

        return articleResults
    }
}