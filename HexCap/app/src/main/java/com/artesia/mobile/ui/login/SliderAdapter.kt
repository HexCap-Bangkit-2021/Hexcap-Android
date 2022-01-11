package com.artesia.mobile.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.artesia.mobile.R
import com.artesia.mobile.databinding.ItemSliderLoginBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter: SliderViewAdapter<SliderAdapter.Holder>() {
    private val listImages = ArrayList<String>()

    fun setImages(images: List<String>){
        this.listImages.clear()
        this.listImages.addAll(images)
        notifyDataSetChanged()
    }

    fun removeImages(){
        this.listImages.clear()
        notifyDataSetChanged()
    }

    override fun getCount(): Int = listImages.size

    override fun onCreateViewHolder(parent: ViewGroup?): Holder {
        val itemImageSliderBinding = ItemSliderLoginBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return Holder(itemImageSliderBinding)
    }

    override fun onBindViewHolder(viewHolder: Holder?, position: Int) {
        val image = listImages[position]
        viewHolder?.bind(image)
    }

    inner class Holder(private val binding: ItemSliderLoginBinding): SliderViewAdapter.ViewHolder(binding.root) {
        fun bind(image: String){
            with(binding){
                Glide.with(itemView.context).load(image)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)).into(imgSliderItem)
            }
        }
    }
}