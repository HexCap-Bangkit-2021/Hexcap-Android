package com.rivaldofez.hexcap.data.source.model

import com.google.gson.annotations.SerializedName

data class Article(

    @field:SerializedName("img")
    val img: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("date_post")
    val datePost: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("writer")
    val writer: String,

    @field:SerializedName("category")
    val category: String
)