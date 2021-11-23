package com.artesia.mobile.data.source.model

import com.google.gson.annotations.SerializedName

data class TempleResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<Temple>,

	@field:SerializedName("message")
	val message: String
)