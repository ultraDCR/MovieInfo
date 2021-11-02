package com.ultradcr.ui_moviedetails.ui

sealed class MovieDetailEvent {
    data class GetMovieById(val movieId:String): MovieDetailEvent()
}