package com.ultradcr.movie_datasource.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LanguageListItemDto(

	@SerialName("value")
	val value: String? ,

	@SerialName("key")
	val key: String? 
)