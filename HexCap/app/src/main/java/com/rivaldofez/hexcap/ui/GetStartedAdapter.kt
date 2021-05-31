package com.rivaldofez.hexcap.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.rivaldofez.hexcap.databinding.ItemPlaceBinding

class GetStartedAdapter(private val callback: GetStartedCallback): RecyclerView.Adapter<GetStartedAdapter.PlaceViewHolder>() {
    private val listPlaces = ArrayList<Place>()

    fun setPlaces(places: List<Place>?){
        if(places == null) return
        this.listPlaces.clear()
        this.listPlaces.addAll(places)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val itemPlaces = ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceViewHolder(itemPlaces)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = listPlaces[position]
        holder.bind(place)
    }

    override fun getItemCount(): Int = listPlaces.size

    inner class PlaceViewHolder(private val binding: ItemPlaceBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place){
            with(binding){
                tvName.text = place.name
                tvCity.text = place.city
                cvPlace.setOnClickListener{callback.onPlaceClick(place)}
            }
        }
    }
}