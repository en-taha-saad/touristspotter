package com.androiddevtaha.touristspotter.di

import com.androiddevtaha.touristspotter.repository.PlacesRepositoryImpl
import com.androiddevtaha.touristspotter.usecase.PlacesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindMovieRepository(
        movieRepositoryImpl: PlacesRepositoryImpl
    ): PlacesRepository
}