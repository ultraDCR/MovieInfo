package com.ultradcr.movie_datasource.cache

import com.ultradcr.movie_datasource.network.model.*
import com.ultradcr.movie_domain.*
import com.ultradcr.moviedatasource.cache.Movie_Entity
import com.ultradcr.moviedatasource.cache.Movie_Home_Entity
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@ExperimentalSerializationApi
fun Movie_Entity.toMovie():Movie{
    return Movie(
            year = year ,
    directors = directors ,
    genreList = genreList.toGenreList(),
    title = title ,
    tvEpisodeInfo = tvEpisodeInfo,
    type = type ,
    imDbRating = imDbRating ,
    runtimeStr = runtimeStr ,
    plotLocal = plotLocal ,
    companies = companies ,
    plot = plot ,
    companyList = companyList.toCompanyList(),
    genres = genres ,
    actorList = actorList.toActorList(),
    imDbRatingVotes = imDbRatingVotes ,
    tvSeriesInfo = tvSeriesInfo ,
    id = id ,
    image = image ,
    fullTitle = fullTitle ,
    runtimeMins = runtimeMins ,
    releaseDate = releaseDate ,
    errorMessage = errorMessage ,
    directorList = directorList.toDirectorList() ,
    writers = writers ,
    stars = stars ,
    countries = countries ,
    originalTitle = originalTitle ,
    awards = awards ,
    starList = starList.toStarList() ?: emptyList(),
    contentRating = contentRating ?: "",
    boxOffice = boxOffice.toBoxOffice(),
    writerList = writerList.toWriterList() ?:emptyList()
            )
}

@ExperimentalSerializationApi
 fun Any?.toDataString():String{
    return Json.encodeToString(this )
}

@ExperimentalSerializationApi
fun List<Any>?.toDataString():String{
    return Json.encodeToString(this )
}

@ExperimentalSerializationApi
fun List<GenreListItem>.genreListToDataString():String{
    return Json.encodeToString(this)
}

@ExperimentalSerializationApi
 fun BoxOffice.boxOfficeToString(): String {
    return Json.encodeToString(this)
}

@ExperimentalSerializationApi
 fun List<WriterListItem>.writerListToString(): String {
    return Json.encodeToString(this)
}

@ExperimentalSerializationApi
 fun List<DirectorListItem>.directorListToString(): String {
    return Json.encodeToString(this)
}
@ExperimentalSerializationApi
 fun List<StarListItem>.starListToString(): String {
    return Json.encodeToString(this)
}
@ExperimentalSerializationApi
 fun List<ActorListItem>.actorListToString(): String{
    return Json.encodeToString(this)
}

@ExperimentalSerializationApi
 fun  List<CompanyListItem> .companyListToString():String{
    return Json.encodeToString(this);
}



@ExperimentalSerializationApi
 fun String.toBoxOffice(): BoxOffice {
    return Json.decodeFromString(this)
}

@ExperimentalSerializationApi
 fun String.toWriterList(): List<WriterListItem> {
    return Json.decodeFromString(this)
}

@ExperimentalSerializationApi
 fun String.toDirectorList(): List<DirectorListItem> {
    return Json.decodeFromString(this)
}
@ExperimentalSerializationApi
 fun String.toStarList(): List<StarListItem> {
    return Json.decodeFromString(this)
}
@ExperimentalSerializationApi
 fun String.toActorList(): List<ActorListItem> {
    return Json.decodeFromString(this)
}

@ExperimentalSerializationApi
 fun String.toCompanyList(): List<CompanyListItem> {
    return Json.decodeFromString<List<CompanyListItem>>(this);
}

@ExperimentalSerializationApi
private fun String.toGenreList(): List<GenreListItem> {
    return Json.decodeFromString<List<GenreListItem>>(this);
}

fun Movie_Home_Entity.toMovieHome(): MovieHome{
    return MovieHome(
        imDbRating,
        image,
        fullTitle,
        imDbRatingCount,
        year,
        rank,
        id,
        rankUpDown,
        title,
        crew
    )
}