package com.ultradcr.ui_moviedetails.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ultradcr.core.DataState
import com.ultradcr.core.Logger
import com.ultradcr.core.UIComponent
import com.ultradcr.movie_interactors.GetMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovie: GetMovie,
    @Named("movieDetailLogger") private val logger: Logger,
    savedStateHandle: SavedStateHandle
):ViewModel() {
    val state: MutableState<MovieDetailState> = mutableStateOf(MovieDetailState())


    init {
        savedStateHandle.get<String>("movieId")?.let {movieId ->
            onTriggerEvent(MovieDetailEvent.GetMovieById(movieId = movieId ))
        }

    }

    fun onTriggerEvent(event: MovieDetailEvent){
        when(event){
            is MovieDetailEvent.GetMovieById -> {
                getMovie(event.movieId)
            }
        }
    }

    private fun getMovie(movieId:String) {

        getMovie.execute(movieId = movieId).onEach {  dataState ->
            when (dataState){
                is DataState.Data -> {
                    state.value = state.value.copy(movie = dataState.data)
                }
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
                is DataState.Response ->{
                    when (dataState.uiComponent){
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }
                        is UIComponent.None -> {
                            logger.log((dataState.uiComponent as UIComponent.None).message)
                        }
                    }
                }
            }

        }.launchIn(viewModelScope)

    }

}