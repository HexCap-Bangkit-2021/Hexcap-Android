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
        )
        const val EXTRA_ID_PAGE = "extra_id_page"
    }

    private lateinit var articleBinding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articleBinding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(articleBinding.root)

        val bundle = intent.extras
        if(bundle != null){
            val category = bundle.getString(EXTRA_ID_PAGE)
            if(category != null){
                val articlePagerAdapter = ArticlePagerAdapter(this)
                articleBinding.vpArticle.adapter = articlePagerAdapter
                if(category == getString(R.string.funfact)){
                    articleBinding.vpArticle.setCurrentItem(0,false)
                }else if(category == getString(R.string.tips)){
                    articleBinding.vpArticle.setCurrentItem(1,false)
                }else if(category == getString(R.string.history)){
                    articleBinding.vpArticle.setCurrentItem(2,false)
                }

                TabLayoutMediator(articleBinding.tbArticle, articleBinding.vpArticle){tab, position ->
                    tab.text = resources.getString(TAB_TITLES[position])
                }.attach()
            }
        }
    }
}