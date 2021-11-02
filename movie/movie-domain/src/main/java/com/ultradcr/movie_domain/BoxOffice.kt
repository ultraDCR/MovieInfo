package com.ultradcr.movie_domain

import kotlinx.serialization.Serializable


@Serializable
data class BoxOffice(
	val grossUSA: String? = null,
	val openingWeekendUSA: String? = null,
	val cumulativeWorldwideGross: String? = null,
	val budget: String? = null
)
