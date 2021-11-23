package com.artesia.mobile.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.artesia.mobile.R
import com.artesia.mobile.data.source.model.Temple
import com.artesia.mobile.databinding.ActivityHomeBinding
import com.artesia.mobile.ui.article.ArticleActivity
import com.artesia.mobile.ui.temple.DetailTempleActivity
import com.artesia.mobile.util.showLoading
import com.artesia.mobile.viewmodel.ViewModelFactoryHome

class HomeActivity : AppCompatActivity(), TempleCallback {
    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)


        val factory = ViewModelFactoryHome.getInstance()
        val viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
        val adapter = TempleAdapter(this)

        viewModel.getAllTemple().observe(this, {temples->
            adapter.setTemples(temples)
        })

        viewModel.getLoadingStatus().observe(this,{status ->
            showLoading(status, homeBinding.loading)
        })

        homeBinding.rvTemple.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        homeBinding.rvTemple.adapter = adapter

        homeBinding.btnTips.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra(ArticleActivity.EXTRA_ID_PAGE, getString(R.string.tips))
            startActivity(intent)
        }

        homeBinding.btnFunfact.setOnClickListener{
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra(ArticleActivity.EXTRA_ID_PAGE, getString(R.string.funfact))
            startActivity(intent)
        }

        homeBinding.btnHistory.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra(ArticleActivity.EXTRA_ID_PAGE, getString(R.string.history))
            startActivity(intent)
        }
    }

    override fun onTempleClick(temple: Temple) {
        val intent = Intent(this, DetailTempleActivity::class.java)
        intent.putExtra(DetailTempleActivity.EXTRA_ID_TEMPLE, temple.id.toString())
        startActivity(intent)
    }
}