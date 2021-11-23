package com.artesia.mobile.data.source.model

import com.google.gson.annotations.SerializedName

data class TriviaDetailResponse(
	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: Trivia,

	@field:SerializedName("message")
	val message: String
)