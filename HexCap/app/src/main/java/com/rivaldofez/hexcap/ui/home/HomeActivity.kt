package com.rivaldofez.hexcap.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
            startActivity(intent)
            Toast.makeText(this, "Funfact", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onTempleClick(temple: Temple) {
        val intent = Intent(this, DetailTempleActivity::class.java)
        intent.putExtra(DetailTempleActivity.EXTRA_ID_TEMPLE, temple.id.toString())
        startActivity(intent)
        Toast.makeText(this, temple.name, Toast.LENGTH_SHORT).show()
    }
}