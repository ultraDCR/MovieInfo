package com.ultradcr.movie_datasource.network

import com.ultradcr.movie_domain.Movie
import com.ultradcr.movie_domain.MovieHome
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

interface MovieService {

    suspend fun getTop100Movie() : List<MovieHome>
    suspend fun getMovieById(movieId:String) : Movie


    companion object Factory {
        fun build(): MovieService {
            return  MovieServiceImp(
                httpClient = HttpClient(Android){
                    install(JsonFeature){
                        serializer = KotlinxSerializer(
                            kotlinx.serialization.json.Json {
                                ignoreUnknownKeys = true
                            }
                        )
                    }
                }
            )
        }
    }

}