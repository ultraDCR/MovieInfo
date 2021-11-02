package com.ultradcr.ui_movielist.di

import com.ultradcr.core.Logger
import com.ultradcr.movie_interactors.GetTop100Movies
import com.ultradcr.movie_interactors.MovieInterators
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieListModule {


    @Provides
    @Singleton
    fun provideGetTop100Movies(
        interactors: MovieInterators
    ): GetTop100Movies{
        return interactors.getTop100Movies
    }

    @Provides
    @Singleton
    @Named("movieListLogger")
    fun provideLogger():Logger{
        return Logger(
            tag = "MovieList",
            isDebug = true
        )
    }


}