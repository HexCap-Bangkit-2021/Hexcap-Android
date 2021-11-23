package com.artesia.mobile.ui.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artesia.mobile.data.source.model.Article
import com.artesia.mobile.databinding.ItemArticleBinding
import com.artesia.mobile.util.formatDate
import com.bumptech.glide.Glide

class ArticleAdapter(private val callback: ArticleCallback): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    private val listArticle = ArrayList<Article>()

    fun setArticles(articles: List<Article>?){
        if(articles == null) return

        this.listArticle.clear()
        this.listArticle.addAll(articles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemArticleBinding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(itemArticleBinding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = listArticle[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int = listArticle.size

    inner class ArticleViewHolder(private val binding: ItemArticleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article){
            with(binding){
                tvTitle.text = article.title
                tvDatepost.text = "Posted on " + formatDate(article.datePost)
                Glide.with(itemView.context).load(article.img).into(imgArticle)
                clArticle.setOnClickListener { callback.onArticleClick(article) }
            }
        }
    }
}