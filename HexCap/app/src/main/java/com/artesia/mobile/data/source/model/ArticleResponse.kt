package com.artesia.mobile.data.source.model

import com.google.gson.annotations.SerializedName

data class ArticleResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<Article>,

	@field:SerializedName("message")
	val message: String
)
