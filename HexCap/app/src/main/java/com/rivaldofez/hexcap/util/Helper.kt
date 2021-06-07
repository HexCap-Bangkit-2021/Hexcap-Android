package com.rivaldofez.hexcap.util

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.core.widget.TextViewCompat
import com.github.ybq.android.spinkit.SpinKitView
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.rivaldofez.hexcap.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun Context.generateButtonTextView(text: String, layout: LinearLayout){
    val tvItem = TextView(this)
    val scale = resources.displayMetrics.density
    val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

    params.setMargins(0,0,(3 * scale + 0.5F).toInt(),0)
    tvItem.layoutParams = params
    tvItem.text = text
    tvItem.background = ContextCompat.getDrawable(this, R.drawable.bg_tagline_item)
    TextViewCompat.setTextAppearance(tvItem, R.style.TaglineItem)

    tvItem.setPadding((4 * scale + 0.5F).toInt())
    layout.addView(tvItem)
}

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun formatDate(value: String): String{
    try {
        val split = value.split("Z").toTypedArray()
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(split[0])
        return SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(date) + " " + split[1]

    } catch (e: ParseException) {
        print("Error while parse date" + e.message.toString())
        return "-"
    }
}

fun showLoading(status: Boolean, loading: SpinKitView){
    if(status){
        val sprite = DoubleBounce()
        loading.visibility = View.VISIBLE
        loading.setIndeterminateDrawable(sprite)
    }else{
        loading.visibility = View.GONE
    }
}