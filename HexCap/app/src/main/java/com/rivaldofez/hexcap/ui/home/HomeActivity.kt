package com.rivaldofez.hexcap.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rivaldofez.hexcap.R
import com.rivaldofez.hexcap.data.source.model.Temple
import com.rivaldofez.hexcap.databinding.ActivityHomeBinding
import com.rivaldofez.hexcap.ui.article.ArticleActivity
import com.rivaldofez.hexcap.ui.temple.DetailTempleActivity
import com.rivaldofez.hexcap.viewmodel.ViewModelFactoryHome

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
        Toast.makeText(this, temple.name, Toast.LENGTH_SHORT).show()
    }
}