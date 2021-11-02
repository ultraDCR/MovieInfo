package com.ultradcr.movieinfo.di

import android.app.Application
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.ultradcr.movie_interactors.MovieInterators
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieInteractorsModule {

    @Provides
    @Singleton
    @Named("movieAndroidSqlDriver") // in case you have another database which required same type in this case SqlDriver
    fun provideAndroidDriver( app: Application): SqlDriver{
        return AndroidSqliteDriver(
            schema = MovieInterators.schema,
            context = app,
            name = MovieInterators.dbName
        )
    }

    @Provides
    @Singleton
    fun provideMovieInteractors(
        @Named("movieAndroidSqlDriver") sqlDriver: SqlDriver,
    ): MovieInterators{
        return MovieInterators.build(sqlDriver = sqlDriver)
    }


}