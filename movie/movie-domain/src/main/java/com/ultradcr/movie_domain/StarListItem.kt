package com.ultradcr.movie_domain

import kotlinx.serialization.Serializable

@Serializable

data class StarListItem(
	val name: String? = null,
	val id: String? = null
)
