package com.ultradcr.movie_datasource.network

object EndPoints {
    const val BASE_URL = "https://imdb-api.com/en/API"
    const val API_KEY = "k_x41abcdg"
    const val TOP_100_MOVIES = "${BASE_URL}/MostPopularMovies/${API_KEY}"
    const val MOVIE = "${BASE_URL}/Title/${API_KEY}"
}