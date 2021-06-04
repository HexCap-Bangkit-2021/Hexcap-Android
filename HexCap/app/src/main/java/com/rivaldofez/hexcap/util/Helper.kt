package com.rivaldofez.hexcap.util

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.core.widget.TextViewCompat
import com.rivaldofez.hexcap.R

fun Context.generateButtonTextView(text: String, layout: LinearLayout){
    val tvItem = TextView(this)
    val scale = resources.displayMetrics.density
    val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

    params.setMargins(0,0,(3 * scale + 0.5F).toInt(),0)
    tvItem.layoutParams = params
    tvItem.text = text
    tvItem.background = ContextCompat.getDrawable(this, R.drawable.bg_tagline_item)
    TextViewCompat.setTextAppearance(tvItem, R.style.TaglineItem)

    tvItem.setPadding((3 * scale + 0.5F).toInt())
    layout.addView(tvItem)
}