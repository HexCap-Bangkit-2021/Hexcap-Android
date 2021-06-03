package com.rivaldofez.hexcap.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rivaldofez.hexcap.R
import com.rivaldofez.hexcap.data.source.model.Temple
import com.rivaldofez.hexcap.databinding.ActivityHomeBinding
import com.rivaldofez.hexcap.ui.article.ArticleActivity
import com.rivaldofez.hexcap.ui.temple.DetailTempleActivity

class HomeActivity : AppCompatActivity(), TempleCallback {
    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)


        val listTemple = ArrayList<Temple>()
        val temple1 = Temple(name = "Candi Borobudur", city = "Magelang", trivia = "", slug = "", rating = 4.8F)
        val temple2 = Temple(name = "Candi Mendut", city = "Yogyakarta", trivia = "", slug = "", rating = 4.5F)
        val temple3 = Temple(name = "Candi Tikus", city = "Jember", trivia = "", slug = "", rating = 4.6F)
        val temple4 = Temple(name = "Candi Asu", city = "Kudus", trivia = "", slug = "", rating = 4.6F)

        listTemple.add(temple1)
        listTemple.add(temple2)
        listTemple.add(temple3)
        listTemple.add(temple4)

        val adapter = TempleAdapter(this)
        adapter.setTemples(listTemple)
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
        startActivity(intent)
        Toast.makeText(this, temple.name, Toast.LENGTH_SHORT).show()
    }
}