package com.rivaldofez.hexcap.ui.trivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rivaldofez.hexcap.data.source.model.Trivia
import com.rivaldofez.hexcap.databinding.ActivityTriviaBinding
import com.rivaldofez.hexcap.viewmodel.ViewModelFactoryTrivia
import java.util.*

class TriviaActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    companion object {
        const val EXTRA_ID_TRIVIA = "extra_id_trivia"
    }

    private lateinit var textToSpeech: TextToSpeech
    private lateinit var triviaBinding: ActivityTriviaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        triviaBinding = ActivityTriviaBinding.inflate(layoutInflater)
        setContentView(triviaBinding.root)

        triviaBinding.btnVoice.visibility = View.GONE
        textToSpeech = TextToSpeech(this, this)

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

        triviaBinding.btnVoice.setOnClickListener {
            runSpeech(triviaBinding.tvDescription.text.toString())
            Log.d("Teston", "Test")
        }
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            val res: Int = textToSpeech.setLanguage(Locale.US)

            if(res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("Speech", "language not supported")
            }else{
                triviaBinding.btnVoice.visibility = View.VISIBLE
            }
        }else{
            Log.e("Speech", "error while initialize")
        }
    }


    private fun setContentView(trivia: Trivia){
        Glide.with(this).load(trivia.img).into(triviaBinding.imgTrivia)
        triviaBinding.tvName.text = trivia.name
        triviaBinding.tvDescription.text = trivia.trivia
        triviaBinding.tvTemple.text = trivia.candiName
    }

    private fun runSpeech(trivia: String){
        textToSpeech.speak(trivia, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onDestroy() {
        if(textToSpeech != null){
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroy()
    }
}