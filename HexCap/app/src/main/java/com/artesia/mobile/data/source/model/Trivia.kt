package com.artesia.mobile.data.source.model

import com.google.gson.annotations.SerializedName

data class Trivia(

    @field:SerializedName("img")
    val img: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("trivia")
    val trivia: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("candi_id")
    val candiId: Int,

    @field:SerializedName("candi_name")
    val candiName: String,

    @field:SerializedName("slug")
    val slug: String
)