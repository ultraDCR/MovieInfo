package com.ultradcr.movie_datasource.network.model

import com.ultradcr.movie_domain.Movie
import com.ultradcr.movie_domain.MovieHome
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(

	@SerialName("imDbRatingCount")
	val imDbRatingCount: String? = "0",

	@SerialName("rank")
	val rank: String? = "" ,

	@SerialName("rankUpDown")
	val rankUpDown: String? = "",

	@SerialName("crew")
	val crew: String? = "",

	@SerialName("keywords")
	val keywords: String? = "",

	@SerialName("year")
	val year: String? = "",

	@SerialName("directors")
	val directors: String? = "",

	@SerialName("genreList")
	val genreList: List<GenreListItemDto>? = emptyList(),

	@SerialName("title")
	val title: String? = "",

	@SerialName("type")
	val type: String? = "" ,

	@SerialName("tvEpisodeInfo")
	val tvEpisodeInfo: String? = "",

	@SerialName("imDbRating")
	val imDbRating: String? = "0",

	@SerialName("trailer")
	val trailer: String?  = "",

	@SerialName("runtimeStr")
	val runtimeStr: String? ="" ,

	@SerialName("plotLocal")
	val plotLocal: String? = "",

	@SerialName("companies")
	val companies: String? = "",

	@SerialName("plot")
	val plot: String? = "" ,

	@SerialName("companyList")
	val companyList: List<CompanyListItemDto>? = emptyList() ,

	@SerialName("genres")
	val genres: String? = "" ,

	@SerialName("ratings")
	val ratings: String? = "0" ,

	@SerialName("actorList")
	val actorList: List<ActorListItemDto>?  = emptyList(),

	@SerialName("imDbRatingVotes")
	val imDbRatingVotes: String? = "",

	@SerialName("tvSeriesInfo")
	val tvSeriesInfo: String? = "",

	@SerialName("id")
	val id: String? = "",

	@SerialName("languageList")
	val languageList: List<LanguageListItemDto>?  = emptyList(),

	@SerialName("wikipedia")
	val wikipedia: String? = "",

	@SerialName("fullCast")
	val fullCast: String? = "",

	@SerialName("image")
	val image: String? = "" ,

	@SerialName("fullTitle")
	val fullTitle: String? = "" ,

	@SerialName("images")
	val images: String? = "",

	@SerialName("runtimeMins")
	val runtimeMins: String? = "" ,

	@SerialName("languages")
	val languages: String? = "",

	@SerialName("releaseDate")
	val releaseDate: String? = "" ,

	@SerialName("similars")
	val similars: List<SimilarsItemDto>?  = emptyList(),

	@SerialName("posters")
	val posters: String? = "" ,

	@SerialName("errorMessage")
	val errorMessage: String? = "",

	@SerialName("metacriticRating")
	val metacriticRating: String? = "0",

	@SerialName("directorList")
	val directorList: List<DirectorListItemDto>?  = emptyList(),

	@SerialName("writers")
	val writers: String?= "" ,

	@SerialName("stars")
	val stars: String? = "" ,

	@SerialName("countries")
	val countries: String? = "" ,

	@SerialName("countryList")
	val countryList: List<CountryListItemDto>?  = emptyList(),

	@SerialName("plotLocalIsRtl")
	val plotLocalIsRtl: Boolean? = false,

	@SerialName("keywordList")
	val keywordList: List<String>? = emptyList() ,

	@SerialName("originalTitle")
	val originalTitle: String? = "" ,

	@SerialName("awards")
	val awards: String? = ""  ,

	@SerialName("tagline")
	val tagline: String? = "" ,

	@SerialName("starList")
	val starList: List<StarListItemDto>?  = emptyList(),

	@SerialName("contentRating")
	val contentRating: String? = "0",

	@SerialName("boxOffice")
	val boxOffice: BoxOfficeDto? = null ,

	@SerialName("writerList")
	val writerList: List<WriterListItemDto>?  = emptyList()
)




fun MovieDto.toMovieHome():MovieHome{
	return MovieHome(
		imDbRating = imDbRating ?: "",
		image = image ?: "",
		fullTitle = fullTitle ?: "",
		imDbRatingCount = imDbRatingCount ?: "",
		year = year ?: "",
		rank =  rank ?: "",
		rankUpDown =  rankUpDown ?: "",
		id =  id ?: "",
		title = title ?: "",
		crew = crew ?: ""
	)
}


fun MovieDto.toMovie() : Movie {
	return  Movie(
		year = year ?: "",
		directors = directors ?: "",
		genreList = genreList?.toGenreListItemList() ?: emptyList(),
		title = title ?: "",
		tvEpisodeInfo = tvEpisodeInfo ?: "",
		type = type ?: "",
		imDbRating = imDbRating ?: "",
		runtimeStr = runtimeStr ?: "",
		plotLocal = plotLocal ?: "",
		companies = companies ?: "",
		plot = plot ?: "",
		companyList = companyList?.toCompanyListItemList() ?: emptyList(),
		genres = genres ?: "",
		actorList = actorList?.toActorListItemList() ?: emptyList(),
		imDbRatingVotes = imDbRatingVotes ?: "",
		tvSeriesInfo = tvSeriesInfo ?:"",
		id = id ?: "",
		image = image ?: "",
		fullTitle = fullTitle ?:"",
		runtimeMins = runtimeMins ?: "0",
		releaseDate = releaseDate ?: "",
		errorMessage = errorMessage ?: "",
		directorList = directorList?.toDirectorListItemList() ?: emptyList(),
		writers = writers ?: "",
		stars = stars ?: "0",
		countries = countries ?: "",
		originalTitle = originalTitle ?: "",
		awards = awards ?: "",
		starList = starList?.toStarListItemList() ?: emptyList(),
		contentRating = contentRating ?: "",
		boxOffice = boxOffice?.toBoxOffice(),
		writerList = writerList?.toWriterListItemList() ?:emptyList()
	)
}