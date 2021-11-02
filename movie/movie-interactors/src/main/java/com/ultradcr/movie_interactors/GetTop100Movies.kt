package com.ultradcr.movie_interactors

import com.ultradcr.core.DataState
import com.ultradcr.core.ProgressBarState
import com.ultradcr.core.UIComponent
import com.ultradcr.movie_datasource.cache.MovieCache
import com.ultradcr.movie_datasource.network.MovieService
import com.ultradcr.movie_domain.MovieHome
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GetTop100Movies(
    private val cache:  MovieCache,
    private val service: MovieService
    ) {

    fun execute(): Flow<DataState<List<MovieHome>>> = flow{
        try{
            emit(
                DataState.Loading<List<MovieHome>>(progressBarState = ProgressBarState.Loading)
            )

            delay(2000)
            val movies: List<MovieHome> = try{
                service.getTop100Movie()
            }catch (e: Exception){
                e.printStackTrace()
                emit(
                    DataState.Response<List<MovieHome>>(
                        uiComponent = UIComponent.Dialog(
                            title = "Error",
                            description = e.message ?: "Unknown Error"
                        )
                    )
                )
                listOf()
            }
            println(movies.toString())
            //cache the network data
            cache.insertMoviesHome(movies)
            //emit data from cache
            val cachedMovies = cache.selectAllMoviesHome()
            emit(
                DataState.Data<List<MovieHome>>(cachedMovies)
            )

        }catch (e: Exception){
            e.printStackTrace()
            emit(
                DataState.Response<List<MovieHome>>(
                    uiComponent = UIComponent.Dialog(
                        title = "Error",
                        description = e.message ?: "Unknown Error"
                    )
                )
            )
        }
        finally {
            emit(DataState.Loading<List<MovieHome>>(progressBarState = ProgressBarState.Idle))
        }
    }

}