package com.rivaldofez.hexcap.ui.detailarticle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rivaldofez.hexcap.data.source.model.Article
import com.rivaldofez.hexcap.databinding.ActivityDetailArticleBinding
import com.rivaldofez.hexcap.util.formatDate

class DetailArticleActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_DETAIL_ARTICLE = "extra_detail_article"
    }

    private lateinit var detailArticleBinding: ActivityDetailArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailArticleBinding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(detailArticleBinding.root)

        val article = intent.getParcelableExtra<Article>(EXTRA_DETAIL_ARTICLE) as Article
        setContentView(article)
    }

    private fun setContentView(article: Article){
        detailArticleBinding.tvTitle.text = article.title
        detailArticleBinding.tvDate.text = formatDate(article.datePost)
        detailArticleBinding.tvDescription.text = article.description
        detailArticleBinding.tvWriter.text = article.writer
        Glide.with(this).load(article.img).into(detailArticleBinding.imgArticle)
    }

}