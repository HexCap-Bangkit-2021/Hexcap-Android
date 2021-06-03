package com.rivaldofez.hexcap.ui.article

import androidx.recyclerview.widget.RecyclerView
import com.rivaldofez.hexcap.databinding.ItemArticleBinding

class ArticleAdapter(private callback: ArticleCallback): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {


    inner class ArticleViewHolder(private val binding: ItemArticleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article){
            with(binding){

            }
        }
    }
}