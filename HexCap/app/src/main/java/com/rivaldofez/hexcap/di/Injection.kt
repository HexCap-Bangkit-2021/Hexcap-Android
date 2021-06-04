package com.rivaldofez.hexcap.di

import com.rivaldofez.hexcap.data.source.ArticleRepository
import com.rivaldofez.hexcap.data.source.TempleRepository
import com.rivaldofez.hexcap.data.source.TriviaRepository
import com.rivaldofez.hexcap.data.source.remote.RemoteDataSource

object Injection {
    fun provideTempleRepository(): TempleRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return TempleRepository.getInstance(remoteDataSource)
    }

    fun provideTriviaRepository(): TriviaRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return TriviaRepository.getInstance(remoteDataSource)
    }

    fun provideArticleRepository(): ArticleRepository{
        val remoteDataSource = RemoteDataSource.getInstance()
        return ArticleRepository.getInstance(remoteDataSource)
    }
}