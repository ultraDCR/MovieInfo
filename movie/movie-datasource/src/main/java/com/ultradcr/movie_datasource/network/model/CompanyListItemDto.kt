package com.ultradcr.movie_datasource.network.model

import com.ultradcr.movie_domain.CompanyListItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompanyListItemDto(

	@SerialName("name")
	val name: String?,

	@SerialName("id")
	val id: String?
)


fun CompanyListItemDto.toCompanyListItem(): CompanyListItem {
	return CompanyListItem(
		name,
		id
	)
}

fun List<CompanyListItemDto>.toCompanyListItemList(): List<CompanyListItem>{
	return this.map { it.toCompanyListItem() }

}
