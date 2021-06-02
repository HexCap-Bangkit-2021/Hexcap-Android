package com.rivaldofez.hexcap.ui.temple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.core.widget.TextViewCompat
import com.rivaldofez.hexcap.MainActivity
import com.rivaldofez.hexcap.R
import com.rivaldofez.hexcap.databinding.ActivityDetailTempleBinding

class DetailTempleActivity : AppCompatActivity() {
    private lateinit var detailTempleBinding: ActivityDetailTempleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailTempleBinding = ActivityDetailTempleBinding.inflate(layoutInflater)
        setContentView(detailTempleBinding.root)

        val tvTaglineItem = TextView(this)
        val scale = resources.displayMetrics.density
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        params.setMargins(0,0,(4 * scale + 0.5F).toInt(),0)
        tvTaglineItem.layoutParams = params
        tvTaglineItem.text = "Buddha"
        tvTaglineItem.background = ContextCompat.getDrawable(this, R.drawable.bg_tagline_item)
        TextViewCompat.setTextAppearance(tvTaglineItem, R.style.TaglineItem)

        tvTaglineItem.setPadding((4 * scale + 0.5F).toInt())
        detailTempleBinding.llTagline.addView(tvTaglineItem)

        detailTempleBinding.btnExplore.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}