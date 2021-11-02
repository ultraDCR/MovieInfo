package com.ultradcr.ui_movielist.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ultradcr.core.DataState
import com.ultradcr.core.Logger
import com.ultradcr.core.UIComponent
import com.ultradcr.movie_interactors.GetTop100Movies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HomeMovieListViewModel @Inject constructor(
    private val getTop100Movies: GetTop100Movies,
    @Named("movieListLogger") private val logger: Logger,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val state: MutableState<MovieHomeListState> = mutableStateOf(MovieHomeListState())


    init {
        onTriggerEvent(HomeMovieListEvent.GetTop100Movies)
    }

    fun onTriggerEvent(event: HomeMovieListEvent){
        when(event){
            is HomeMovieListEvent.GetTop100Movies -> {
                getTop100Movies()
            }
        }
    }

    private fun getTop100Movies() {

        getTop100Movies.execute().onEach {  dataState ->
            when (dataState){
                is DataState.Data -> {
                    state.value = state.value.copy(movieHome = dataState.data ?: listOf())
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