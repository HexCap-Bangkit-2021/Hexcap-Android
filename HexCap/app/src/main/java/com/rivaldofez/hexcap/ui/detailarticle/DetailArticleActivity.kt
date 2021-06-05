package com.rivaldofez.hexcap.ui.detailarticle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rivaldofez.hexcap.R
import com.rivaldofez.hexcap.databinding.ActivityArticleBinding

class DetailArticleActivity : AppCompatActivity() {
    private lateinit var detailArticleBinding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailArticleBinding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(detailArticleBinding.root)
    }
}