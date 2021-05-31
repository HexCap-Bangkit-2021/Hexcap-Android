package com.rivaldofez.hexcap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rivaldofez.hexcap.R
import com.rivaldofez.hexcap.databinding.ActivityGetStartedBinding

class GetStartedActivity : AppCompatActivity(), GetStartedCallback {
    private lateinit var getStartedBinding: ActivityGetStartedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getStartedBinding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(getStartedBinding.root)

        val listPlaces = ArrayList<Place>()
        val place1 = Place(name = "Borobudur", city = "Magelang", slug = "candi-borobudur", trivia = "Stupa Buddha")
        val place2 = Place(name = "Prambanan", city = "Yogyakarta", slug = "candi-prambanan", trivia = "Stupa Siwa")
        val place3 = Place(name = "Asu", city = "Yogyakarta", slug = "candi-asu", trivia = "Tidak ada patung anjingnya")
        listPlaces.add(place1)
        listPlaces.add(place2)
        listPlaces.add(place3)

        val adapter = GetStartedAdapter(this)

        adapter.setPlaces(listPlaces)
        getStartedBinding.rvCarousel.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        getStartedBinding.rvCarousel.adapter = adapter
    }

    override fun onPlaceClick(place: Place) {
        Toast.makeText(this,place.name, Toast.LENGTH_SHORT).show()
    }
}