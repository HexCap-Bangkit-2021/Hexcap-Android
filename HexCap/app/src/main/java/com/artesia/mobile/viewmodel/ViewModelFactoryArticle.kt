package com.artesia.mobile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artesia.mobile.data.source.ArticleRepository
import com.artesia.mobile.di.Injection
import com.artesia.mobile.ui.article.ArticleViewModel

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
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ArticleViewModel::class.java) -> {
                ArticleViewModel(articleRepository) as T
            }
            else -> throw Throwable("Unknown View Model" + modelClass.name)
        }
    }
}