package com.androiddevtaha.touristspotter.di

import com.androiddevtaha.touristspotter.remote.source.RemoteDataSourceImpl
import com.androiddevtaha.touristspotter.repository.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(
        retrofitDataSource: RemoteDataSourceImpl
    ): RemoteDataSource

}