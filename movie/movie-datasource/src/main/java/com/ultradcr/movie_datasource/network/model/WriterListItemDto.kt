package com.ultradcr.movie_datasource.network.model

import com.ultradcr.movie_domain.WriterListItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WriterListItemDto(

	@SerialName("name")
	val name: String? ,

	@SerialName("id")
	val id: String? 
)



fun WriterListItemDto.toWriterListItem(): WriterListItem {
	return WriterListItem(
		name,
		id
	)
}

fun List<WriterListItemDto>.toWriterListItemList(): List<WriterListItem>{
	return this.map { it.toWriterListItem() }

}
