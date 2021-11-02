package com.ultradcr.movie_domain

import kotlinx.serialization.Serializable

@Serializable
data class GenreListItem(
	val value: String? = null,
	val key: String? = null
)
