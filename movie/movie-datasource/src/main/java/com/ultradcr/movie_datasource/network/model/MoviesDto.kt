package com.ultradcr.movie_datasource.network.model

import com.ultradcr.movie_domain.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesDto (
    @SerialName("items")
    val items: List<MovieDto>? = emptyList(),

    @SerialName("errorMessage")
    val errorMessage: String? = "",

)

fun MoviesDto.toListOfMovie(): List<Movie>{
    return items?.map { it.toMovie() } ?: emptyList()
}