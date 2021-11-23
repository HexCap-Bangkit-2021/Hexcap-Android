package com.artesia.mobile.ui.temple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.artesia.mobile.data.source.model.Temple
import com.artesia.mobile.databinding.ActivityDetailTempleBinding
import com.artesia.mobile.ml.TriviaFinderActivity
import com.artesia.mobile.ui.maps.MapsActivity
import com.artesia.mobile.util.generateButtonTextView
import com.artesia.mobile.util.showLoading
import com.artesia.mobile.viewmodel.ViewModelFactoryTemple

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

                viewModel.getLoadingStatus().observe(this, {status ->
                    showLoading(status, detailTempleBinding.loading)
                })
            }
        }

        detailTempleBinding.btnExplore.setOnClickListener {
            val intent = Intent(this, TriviaFinderActivity::class.java)
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

        val tags = temple.tagline.split(",").toTypedArray()
        for(tag in tags){
            this.generateButtonTextView(tag, detailTempleBinding.llTagline)
        }

        detailTempleBinding.btnShowMap.setOnClickListener{
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra(MapsActivity.EXTRA_LAT, temple.lat)
            intent.putExtra(MapsActivity.EXTRA_LONG, temple.long)
            intent.putExtra(MapsActivity.EXTRA_NAME, temple.name)
            startActivity(intent)
        }

    }
}