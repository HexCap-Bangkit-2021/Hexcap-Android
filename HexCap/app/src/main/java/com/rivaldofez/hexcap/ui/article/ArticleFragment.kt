package com.rivaldofez.hexcap.ui.article

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rivaldofez.hexcap.R
import com.rivaldofez.hexcap.data.source.model.Article
import com.rivaldofez.hexcap.databinding.FragmentArticleBinding
import com.rivaldofez.hexcap.viewmodel.ViewModelFactoryArticle


class ArticleFragment : Fragment(), ArticleCallback {
    var option: String? = null
    private lateinit var binding: FragmentArticleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactoryArticle.getInstance()
        val viewModel = ViewModelProvider(this, factory)[ArticleViewModel::class.java]

        if(option == ArticlePagerAdapter.mTestimonial){
            val testimonialAdapter = ArticleAdapter(this)
            binding.rvArticle.layoutManager = LinearLayoutManager(requireActivity())
            binding.rvArticle.adapter = testimonialAdapter
            viewModel.setCurrentCategory("testimonial")
            viewModel.getArticleByCategory().observe(viewLifecycleOwner,{articles ->
                testimonialAdapter.setArticles(articles)
            })
        }else if(option == ArticlePagerAdapter.mHistory){
            val historyAdapter = ArticleAdapter(this)
            binding.rvArticle.layoutManager = LinearLayoutManager(requireActivity())
            binding.rvArticle.adapter = historyAdapter
            viewModel.setCurrentCategory("history")
            viewModel.getArticleByCategory().observe(viewLifecycleOwner,{articles ->
                historyAdapter.setArticles(articles)
            })
        }else if(option == ArticlePagerAdapter.mTips){
            val tipsAdapter = ArticleAdapter(this)
            binding.rvArticle.layoutManager = LinearLayoutManager(requireActivity())
            binding.rvArticle.adapter = tipsAdapter
            viewModel.setCurrentCategory("tips")
            viewModel.getArticleByCategory().observe(viewLifecycleOwner,{articles ->
                tipsAdapter.setArticles(articles)
            })
        }else if(option == ArticlePagerAdapter.mFunfact){
            val funfactAdapter = ArticleAdapter(this)
            binding.rvArticle.layoutManager = LinearLayoutManager(requireActivity())
            binding.rvArticle.adapter = funfactAdapter
            viewModel.setCurrentCategory("funfact")
            viewModel.getArticleByCategory().observe(viewLifecycleOwner,{articles ->
                funfactAdapter.setArticles(articles)
            })
        }
    }

    override fun onArticleClick(article: Article) {
        Log.d("teston", article.description)
    }
}