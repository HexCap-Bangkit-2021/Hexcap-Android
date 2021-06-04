package com.rivaldofez.hexcap.ui.trivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rivaldofez.hexcap.data.source.model.Trivia
import com.rivaldofez.hexcap.databinding.ActivityTriviaBinding
import com.rivaldofez.hexcap.viewmodel.ViewModelFactoryTrivia

class TriviaActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID_TRIVIA = "extra_id_trivia"
    }

    private lateinit var triviaBinding: ActivityTriviaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        triviaBinding = ActivityTriviaBinding.inflate(layoutInflater)
        setContentView(triviaBinding.root)

        val factory = ViewModelFactoryTrivia.getInstance()
        val viewModel = ViewModelProvider(this, factory)[TriviaViewModel::class.java]

        val bundle = intent.extras
        if(bundle != null){
            bundle.getString(EXTRA_ID_TRIVIA)?.let { Log.d("Teston", it) }
            val triviaId = bundle.getString(EXTRA_ID_TRIVIA)
            if(triviaId != null){
                viewModel.setCurrentTrivia(triviaId)
                viewModel.getDetailTrivia().observe(this, {trivia->
                    setContentView(trivia)
                })
            }
        }
    }

    private fun setContentView(trivia: Trivia){
        Glide.with(this).load(trivia.img).into(triviaBinding.imgTrivia)
        triviaBinding.tvName.text = trivia.name
        triviaBinding.tvDescription.text = trivia.trivia
    }
}