package com.ultradcr.movie_domain

import kotlinx.serialization.Serializable


@Serializable
data class ActorListItem(
	val image: String? = null,
	val asCharacter: String? = null,
	val name: String? = null,
	val id: String? = null
)
