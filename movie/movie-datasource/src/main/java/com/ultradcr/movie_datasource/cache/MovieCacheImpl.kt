package com.ultradcr.movie_datasource.cache

import com.ultradcr.movie_datasource.network.model.*
import com.ultradcr.movie_domain.BoxOffice
import com.ultradcr.movie_domain.Movie
import com.ultradcr.movie_domain.MovieHome
import com.ultradcr.moviedatasource.cache.MovieDbQueries
import kotlinx.serialization.ExperimentalSerializationApi
import java.lang.Exception

@ExperimentalSerializationApi

class MovieCacheImpl(
    private val movieDatabase: MovieDatabase
) : MovieCache {
    private var queries:MovieDbQueries = movieDatabase.movieDbQueries

    override suspend fun getMovie(id: String): Movie? {
        return queries.getMovie(id).executeAsOne().toMovie()
    }

    override suspend fun removeMovie(id: String) {
        queries.removeMovie(id)
    }

    override suspend fun selectAllMovies(): List<Movie> {
        return queries.selectAllMovies().executeAsList().map { it.toMovie() }
    }

    override suspend fun insertMovies(movies: List<Movie>) {
        for (movie in movies) {
            try {
                insertMovie(movie)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override suspend fun insertMovie(movie: Movie) {
        movie.run {
            queries.insertMovie(
                year = year ?: "",
                directors = directors ?: "",
                genreList = genreList.genreListToDataString(),
                title = title ?: "",
                tvEpisodeInfo = (tvEpisodeInfo ?: "") as String,
                type = type ?: "",
                imDbRating = imDbRating ?: "",
                runtimeStr = runtimeStr ?: "",
                plotLocal = plotLocal ?: "",
                companies = companies ?: "",
                plot = plot ?: "",
                companyList = companyList.companyListToString(),
                genres = genres ?: "",
                actorList = actorList.actorListToString(),
                imDbRatingVotes = imDbRatingVotes ?: "",
                tvSeriesInfo = (tvSeriesInfo ?: "") as String,
                id = id ?: "",
                image = image ?: "",
                fullTitle = fullTitle ?:"",
                runtimeMins = runtimeMins ?: "0",
                releaseDate = releaseDate ?: "",
                errorMessage = errorMessage ?: "",
                directorList = directorList.directorListToString(),
                writers = writers ?: "",
                stars = stars ?: "0",
                countries = countries ?: "",
                originalTitle = originalTitle ?: "",
                awards = awards ?: "",
                starList = starList.starListToString(),
                contentRating = contentRating ?: "",
                boxOffice = (boxOffice ?: BoxOffice()).boxOfficeToString(),
                writerList = writerList.writerListToString()
            )
        }
    }

    override suspend fun getMovieHome(id: String): MovieHome? {
        return queries.getHomeMovie(id).executeAsOne().toMovieHome()

    }

    override suspend fun removeMovieHome(id: String) {
        queries.removeHomeMovie(id)
    }

    override suspend fun selectAllMoviesHome(): List<MovieHome> {
        return queries.selectAllHomeMovies().executeAsList().map { it.toMovieHome() }
    }

    override suspend fun insertMoviesHome(movies: List<MovieHome>) {
        for (homeMovie in movies) {
            try {
                insertMovieHome(homeMovie)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override suspend fun insertMovieHome(movie: MovieHome) {
        movie.run {
            queries.insertHomeMovie(
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
    }

    override suspend fun searchMovieByTitle(title: String): List<MovieHome> {
        return queries.searchMovieByTitle(title).executeAsList().map { it.toMovieHome() }
    }

    override suspend fun searchMovieByImDbRating(rating: String): List<MovieHome> {
        return queries.searchMovieByImDbRatingy(rating).executeAsList().map { it.toMovieHome() }
    }
}