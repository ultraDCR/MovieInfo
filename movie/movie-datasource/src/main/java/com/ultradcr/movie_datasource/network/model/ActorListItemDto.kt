package com.ultradcr.movie_datasource.network.model

import com.ultradcr.movie_domain.ActorListItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActorListItemDto(

	@SerialName("image")
	val image: String?,

	@SerialName("asCharacter")
	val asCharacter: String?,

	@SerialName("name")
	val name: String? ,

	@SerialName("id")
	val id: String? 
)


fun ActorListItemDto.toActorListItem(): ActorListItem {
	return ActorListItem(
		image,
		asCharacter,
		name,
		id
	)
}

fun List<ActorListItemDto>.toActorListItemList(): List<ActorListItem>{
	return this.map { it.toActorListItem() }

}
