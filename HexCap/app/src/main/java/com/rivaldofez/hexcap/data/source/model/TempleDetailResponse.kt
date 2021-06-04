package com.rivaldofez.hexcap.data.source.model

import com.google.gson.annotations.SerializedName

data class TempleDetailResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: Temple,

	@field:SerializedName("message")
	val message: String
)
