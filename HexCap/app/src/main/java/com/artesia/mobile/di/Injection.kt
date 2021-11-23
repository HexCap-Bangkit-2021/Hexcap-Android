package com.artesia.mobile.di

import com.artesia.mobile.data.source.ArticleRepository
import com.artesia.mobile.data.source.TempleRepository
import com.artesia.mobile.data.source.TriviaRepository
import com.artesia.mobile.data.source.remote.RemoteDataSource

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