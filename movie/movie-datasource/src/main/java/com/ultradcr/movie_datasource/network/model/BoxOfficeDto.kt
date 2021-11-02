package com.ultradcr.movie_datasource.network.model

import com.ultradcr.movie_domain.BoxOffice
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BoxOfficeDto(

	@SerialName("grossUSA")
	val grossUSA: String? ,

	@SerialName("openingWeekendUSA")
	val openingWeekendUSA: String? ,

	@SerialName("cumulativeWorldwideGross")
	val cumulativeWorldwideGross: String? ,

	@SerialName("budget")
	val budget: String? 

)

fun BoxOfficeDto.toBoxOffice():BoxOffice{
	return BoxOffice(
		grossUSA, openingWeekendUSA, cumulativeWorldwideGross, budget
	)
}