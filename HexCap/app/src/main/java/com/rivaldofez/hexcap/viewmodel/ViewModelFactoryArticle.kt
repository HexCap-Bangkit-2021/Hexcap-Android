package com.rivaldofez.hexcap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rivaldofez.hexcap.data.source.ArticleRepository
import com.rivaldofez.hexcap.di.Injection
import com.rivaldofez.hexcap.ui.article.ArticleViewModel
import com.rivaldofez.hexcap.ui.home.HomeViewModel

class ViewModelFactoryArticle private constructor(private val articleRepository: ArticleRepository): ViewModelProvider.NewInstanceFactory(){
    companion object{
        private var instance: ViewModelFactoryArticle? = null

        fun getInstance(): ViewModelFactoryArticle =
            instance ?: synchronized(this){
                instance ?: ViewModelFactoryArticle(Injection.provideArticleRepository()).apply {
                    instance = this
                }
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ArticleViewModel::class.java) -> {
                ArticleViewModel(articleRepository) as T
            }
            else -> throw Throwable("Unknown View Model" + modelClass.name)
        }
    }
}