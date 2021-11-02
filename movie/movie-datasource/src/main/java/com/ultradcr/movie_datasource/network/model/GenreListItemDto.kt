package com.ultradcr.movie_datasource.network.model

import com.ultradcr.movie_domain.GenreListItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenreListItemDto(

	@SerialName("value")
	val value: String? ,

	@SerialName("key")
	val key: String?
)

fun GenreListItemDto.toGenreListItem(): GenreListItem{
	return GenreListItem(
		value,
		key
	)
}

fun List<GenreListItemDto>.toGenreListItemList(): List<GenreListItem>{
	return this.map { it.toGenreListItem() }
}