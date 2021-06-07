package com.rivaldofez.hexcap.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.rivaldofez.hexcap.R
import com.rivaldofez.hexcap.databinding.ActivitySplashBinding
import com.rivaldofez.hexcap.ui.home.HomeActivity
import com.bumptech.glide.Glide
import com.github.ybq.android.spinkit.style.DoubleBounce

class SplashActivity : AppCompatActivity() {
    companion object {
        private const val SPLASH_TIME : Long = 3000
    }

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        Glide.with(this).load(R.drawable.logo_candhi).into(splashBinding.imgLogoSplash)

        val sprite = DoubleBounce()
        splashBinding.loading.visibility = View.VISIBLE
        splashBinding.loading.setIndeterminateDrawable(sprite)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
            splashBinding.loading.visibility = View.INVISIBLE
        }, SPLASH_TIME)
    }
}