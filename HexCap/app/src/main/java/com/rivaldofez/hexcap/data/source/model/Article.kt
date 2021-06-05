package com.rivaldofez.hexcap.data.source.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(

    @field:SerializedName("img")
    val img: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("date_post")
    val datePost: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("writer")
    val writer: String,

    @field:SerializedName("category")
    val category: String
):Parcelable