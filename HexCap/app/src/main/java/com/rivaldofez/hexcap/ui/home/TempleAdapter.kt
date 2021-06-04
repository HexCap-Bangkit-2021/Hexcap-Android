package com.rivaldofez.hexcap.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rivaldofez.hexcap.data.source.model.Temple
import com.rivaldofez.hexcap.databinding.ItemTempleDestinationBinding

class TempleAdapter(private val callback: TempleCallback): RecyclerView.Adapter<TempleAdapter.TempleViewHolder>() {
    private val listTemples = ArrayList<Temple>()

    fun setTemples(temples: List<Temple>?){
        if (temples == null ) return
        listTemples.clear()
        listTemples.addAll(temples)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempleViewHolder {
        val itemTemple = ItemTempleDestinationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TempleViewHolder(itemTemple)
    }

    override fun onBindViewHolder(holder: TempleViewHolder, position: Int) {
        val temple = listTemples[position]
        holder.bind(temple)
    }

    override fun getItemCount(): Int = listTemples.size

    inner class TempleViewHolder(private val binding: ItemTempleDestinationBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(temple: Temple){
            with(binding){
                Glide.with(itemView.context).load(temple.img).into(imgTemple)
                tvName.text = temple.name
                tvCity.text = temple.city
                tvRate.text = temple.rating.toString()
                cvTemple.setOnClickListener{callback.onTempleClick(temple)}
            }
        }
    }
}