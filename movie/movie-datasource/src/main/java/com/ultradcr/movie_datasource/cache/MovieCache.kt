package com.ultradcr.movie_datasource.cache

import com.squareup.sqldelight.db.SqlDriver
import com.ultradcr.movie_domain.Movie
import com.ultradcr.movie_domain.MovieHome
import kotlinx.serialization.ExperimentalSerializationApi

interface MovieCache {

    suspend fun getMovie(id:String): Movie?
    suspend fun removeMovie(id:String)

    suspend fun selectAllMovies():List<Movie>

    suspend fun insertMovies(movies: List<Movie>)
    suspend fun insertMovie(movie: Movie)


    suspend fun getMovieHome(id:String): MovieHome?
    suspend fun removeMovieHome(id:String)

    suspend fun selectAllMoviesHome():List<MovieHome>

    suspend fun insertMoviesHome(movies: List<MovieHome>)
    suspend fun insertMovieHome(movie: MovieHome)

    suspend fun searchMovieByTitle(title: String): List<MovieHome>

    suspend fun searchMovieByImDbRating(rating: String): List<MovieHome>


    companion object Factory{
        @ExperimentalSerializationApi
        fun build(sqlDriver:SqlDriver):MovieCache{
            return MovieCacheImpl(MovieDatabase(sqlDriver))
        }

        val schema: SqlDriver.Schema = MovieDatabase.Schema

        val dbName:String  = "movies.db"
    }

}