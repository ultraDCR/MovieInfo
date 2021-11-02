package com.ultradcr.movie_datasource.network.model

import com.ultradcr.movie_domain.DirectorListItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DirectorListItemDto(

	@SerialName("name")
	val name: String? ,

	@SerialName("id")
	val id: String? 
)



fun DirectorListItemDto.toDirectorListItem(): DirectorListItem {
	return DirectorListItem(
		name,
		id
	)
}

fun List<DirectorListItemDto>.toDirectorListItemList(): List<DirectorListItem>{
	return this.map { it.toDirectorListItem() }

}
