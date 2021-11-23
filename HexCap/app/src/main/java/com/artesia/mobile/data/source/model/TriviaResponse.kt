package com.artesia.mobile.data.source.model

import com.google.gson.annotations.SerializedName

data class TriviaResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<Trivia>,

	@field:SerializedName("message")
	val message: String
)


