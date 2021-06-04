package com.rivaldofez.hexcap.ui.article

import com.rivaldofez.hexcap.data.source.model.Article

interface ArticleCallback {
    fun onArticleClick(article: Article)
}