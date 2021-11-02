package com.ultradcr.ui_movielist.ui

sealed class HomeMovieListEvent {
    object GetTop100Movies: HomeMovieListEvent()
}