package com.rivaldofez.hexcap.ui.article

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayoutMediator
import com.rivaldofez.hexcap.R
import com.rivaldofez.hexcap.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {
    companion object {
        @StringRes
        val TAB_TITLES = intArrayOf(
            R.string.funfact,
            R.string.tipsandtrick,
            R.string.history,
            R.string.testimony
        )
    }

    private lateinit var articleBinding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articleBinding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(articleBinding.root)

        val articlePagerAdapter = ArticlePagerAdapter(this)
        articleBinding.vpArticle.adapter = articlePagerAdapter
        TabLayoutMediator(articleBinding.tbArticle, articleBinding.vpArticle){tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

    }
}