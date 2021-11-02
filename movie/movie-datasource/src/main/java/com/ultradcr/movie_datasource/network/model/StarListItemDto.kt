package com.ultradcr.movie_datasource.network.model

import com.ultradcr.movie_domain.StarListItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StarListItemDto(

	@SerialName("name")
	val name: String? ,

	@SerialName("id")
	val id: String? 
)


fun StarListItemDto.toStarListItem(): StarListItem {
	return StarListItem(
		name,
		id
	)
}

fun List<StarListItemDto>.toStarListItemList(): List<StarListItem>{
	return this.map { it.toStarListItem() }

}
