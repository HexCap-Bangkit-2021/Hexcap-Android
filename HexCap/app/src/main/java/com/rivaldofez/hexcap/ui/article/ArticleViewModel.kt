package com.rivaldofez.hexcap.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rivaldofez.hexcap.data.source.ArticleRepository
import com.rivaldofez.hexcap.data.source.model.Article

class ArticleViewModel(private val articleRepository: ArticleRepository): ViewModel() {
    private lateinit var category: String

    fun setCurrentCategory(category: String){
        this.category = category
    }

    fun getAllArticle(): LiveData<List<Article>> = articleRepository.getAllArticles()

    fun getArticleByCategory(): LiveData<List<Article>> = articleRepository.getArticleCategory(category)

    fun getLoadingStatus(): LiveData<Boolean> = articleRepository.isLoading
}