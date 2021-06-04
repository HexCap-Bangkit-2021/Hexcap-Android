package com.rivaldofez.hexcap.data.source

import androidx.lifecycle.LiveData
import com.rivaldofez.hexcap.data.source.model.Article
import com.rivaldofez.hexcap.data.source.model.Temple

interface ArticleDataSource {
    fun getAllArticles(): LiveData<List<Article>>

    fun getArticleCategory(category: String): LiveData<List<Article>>
}