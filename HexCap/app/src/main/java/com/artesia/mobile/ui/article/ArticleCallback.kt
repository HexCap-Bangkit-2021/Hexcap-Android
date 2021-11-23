package com.artesia.mobile.ui.article

import com.artesia.mobile.data.source.model.Article

interface ArticleCallback {
    fun onArticleClick(article: Article)
}