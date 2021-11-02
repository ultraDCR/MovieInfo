package com.ultradcr.movie_interactors

import com.squareup.sqldelight.db.SqlDriver
import com.ultradcr.movie_datasource.cache.MovieCache
import com.ultradcr.movie_datasource.network.MovieService

data class MovieInterators(
    val getTop100Movies: GetTop100Movies,
    val getMovie: GetMovie
){

    companion object Factory{
        fun build(sqlDriver: SqlDriver): MovieInterators {
            val service = MovieService.build()
            val cache = MovieCache.build(sqlDriver)
            return MovieInterators(
                GetTop100Movies(
                    service = service,
                    cache = cache,
                ),
                GetMovie(
                    service = service,
                    cache = cache,
                ),
            )
        }
        val schema: SqlDriver.Schema = MovieCache.schema

        val dbName:String  = "movies.db"
    }
}