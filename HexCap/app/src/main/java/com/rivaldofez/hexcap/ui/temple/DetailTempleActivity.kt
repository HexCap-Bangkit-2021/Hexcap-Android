package com.rivaldofez.hexcap.ui.temple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.core.widget.TextViewCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rivaldofez.hexcap.MainActivity
import com.rivaldofez.hexcap.R
import com.rivaldofez.hexcap.data.source.model.Temple
import com.rivaldofez.hexcap.databinding.ActivityDetailTempleBinding
import com.rivaldofez.hexcap.ui.maps.MapsActivity
import com.rivaldofez.hexcap.viewmodel.ViewModelFactoryTemple

class DetailTempleActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID_TEMPLE = "extra_id_temple"
    }

    private lateinit var detailTempleBinding: ActivityDetailTempleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailTempleBinding = ActivityDetailTempleBinding.inflate(layoutInflater)
        setContentView(detailTempleBinding.root)

        val factory = ViewModelFactoryTemple.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailTempleViewModel::class.java]

        val bundle = intent.extras
        if(bundle != null){
            val templeId = bundle.getString(EXTRA_ID_TEMPLE)
            if(templeId != null){
                viewModel.setCurrentTemple(templeId)
                viewModel.getDetailTemple().observe(this,{temple->
                    setContentView(temple)
                })
            }
        }

//        val tvTaglineItem = TextView(this)
//        val scale = resources.displayMetrics.density
//        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//
//        params.setMargins(0,0,(4 * scale + 0.5F).toInt(),0)
//        tvTaglineItem.layoutParams = params
//        tvTaglineItem.text = "Buddha"
//        tvTaglineItem.background = ContextCompat.getDrawable(this, R.drawable.bg_tagline_item)
//        TextViewCompat.setTextAppearance(tvTaglineItem, R.style.TaglineItem)
//
//        tvTaglineItem.setPadding((4 * scale + 0.5F).toInt())
//        detailTempleBinding.llTagline.addView(tvTaglineItem)

        detailTempleBinding.btnExplore.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        detailTempleBinding.btnShowMap.setOnClickListener{
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setContentView(temple: Temple){
        Glide.with(this).load(temple.img).into(detailTempleBinding.imgBackdrop)
        detailTempleBinding.tvName.text = temple.name
        detailTempleBinding.tvAddress.text = temple.address
        detailTempleBinding.tvCity.text = temple.city
        detailTempleBinding.tvRate.text = temple.rating.toString()
        detailTempleBinding.tvDescription.text = temple.description
    }
}