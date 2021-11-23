package com.artesia.mobile.ml

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.artesia.mobile.databinding.RecognitionItemBinding

class RecognitionAdapter(private val ctx: Context, private val callback: PredictionCallback) :
    ListAdapter<Recognition, RecognitionAdapter.RecognitionViewHolder>(RecognitionDiffUtil()) {

    /**
     * Inflating the ViewHolder with recognition_item layout and data binding
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecognitionViewHolder {
        val inflater = LayoutInflater.from(ctx)
        val binding = RecognitionItemBinding.inflate(inflater, parent, false)
        return RecognitionViewHolder(binding)
    }

    // Binding the data fields to the RecognitionViewHolder
    override fun onBindViewHolder(holder: RecognitionViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    private class RecognitionDiffUtil : DiffUtil.ItemCallback<Recognition>() {
        override fun areItemsTheSame(oldItem: Recognition, newItem: Recognition): Boolean {
            return oldItem.label == newItem.label
        }

        override fun areContentsTheSame(oldItem: Recognition, newItem: Recognition): Boolean {
            return oldItem.confidence == newItem.confidence
        }
    }

    inner class RecognitionViewHolder(private val binding: RecognitionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Binding all the fields to the view - to see which UI element is bind to which field, check
        // out layout/recognition_item.xml
        fun bindTo(recognition: Recognition) {
            binding.recognitionItem = recognition
            binding.executePendingBindings()
            binding.llPred.setOnClickListener { callback.onRecognitionClick(recognition)}
        }
    }

}

