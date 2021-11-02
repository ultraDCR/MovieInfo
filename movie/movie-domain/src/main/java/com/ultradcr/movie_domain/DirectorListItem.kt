package com.ultradcr.movie_domain

import kotlinx.serialization.Serializable

@Serializable
data class DirectorListItem(
	val name: String? = null,
	val id: String? = null
)
