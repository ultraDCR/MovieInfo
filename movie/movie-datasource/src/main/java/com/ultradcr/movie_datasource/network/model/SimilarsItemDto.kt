package com.ultradcr.movie_datasource.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimilarsItemDto(

	@SerialName("imDbRating")
	val imDbRating: String? ,

	@SerialName("image")
	val image: String? ,

	@SerialName("fullTitle")
	val fullTitle: String? ,

	@SerialName("year")
	val year: String? ,

	@SerialName("plot")
	val plot: String? ,

	@SerialName("genres")
	val genres: String? ,

	@SerialName("directors")
	val directors: String? ,

	@SerialName("id")
	val id: String? ,

	@SerialName("stars")
	val stars: String? ,

	@SerialName("title")
	val title: String? 
)