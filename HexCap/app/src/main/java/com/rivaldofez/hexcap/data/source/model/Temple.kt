package com.rivaldofez.hexcap.data.source.model

import com.google.gson.annotations.SerializedName

data class Temple(

    @field:SerializedName("img")
    val img: String,

    @field:SerializedName("address")
    val address: String,

    @field:SerializedName("city")
    val city: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("tagline")
    val tagline: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("lat")
    val lat: Double,

    @field:SerializedName("long")
    val jsonMemberLong: Double
)
