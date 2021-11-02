package com.ultradcr.movie_datasource.network

import com.ultradcr.movie_datasource.network.model.MovieDto
import com.ultradcr.movie_datasource.network.model.MoviesDto
import com.ultradcr.movie_datasource.network.model.toMovie
import com.ultradcr.movie_datasource.network.model.toMovieHome
import com.ultradcr.movie_domain.Movie
import com.ultradcr.movie_domain.MovieHome
import io.ktor.client.*
import io.ktor.client.request.*

class MovieServiceImp(
    private val httpClient: HttpClient
)  : MovieService {

    override suspend fun getTop100Movie(): List<MovieHome> {
        return httpClient.get<MoviesDto>{
            url(EndPoints.TOP_100_MOVIES)
        }.items?.map { it.toMovieHome() } ?: emptyList()
    }

    override suspend fun getMovieById(movieId: String): Movie {
        return httpClient.get<MovieDto>{
            url(EndPoints.MOVIE+"/$movieId")
        }.toMovie()
    }

}