package com.artesia.mobile.data.source

import androidx.lifecycle.LiveData
import com.artesia.mobile.data.source.model.Article

interface ArticleDataSource {
    fun getAllArticles(): LiveData<List<Article>>

    fun getArticleCategory(category: String): LiveData<List<Article>>
}