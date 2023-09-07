package com.androiddevtaha.touristspotter.repository

import com.androiddevtaha.touristspotter.entites.placeDetails.PlaceDetails
import com.androiddevtaha.touristspotter.entites.places.Places
import com.androiddevtaha.touristspotter.repository.mapper.toEntity
import com.androiddevtaha.touristspotter.usecase.PlacesRepository
import javax.inject.Inject

class PlacesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : PlacesRepository {
    override suspend fun getAllPlaces(
        lonMin: Double,
        lonMax: Double,
        latMin: Double,
        latMax: Double,
        kinds: String,
        limit: Int
    ): Places {
        return remoteDataSource.getAllPlaces(
            lonMin = lonMin,
            lonMax = lonMax,
            latMin = latMin,
            latMax = latMax,
            kinds = kinds,
            limit = limit
        ).toEntity()
    }

    override suspend fun getNearestPlaces(lon: Double, lat: Double, radius: Int): Places {
        return remoteDataSource.getNearestPlaces(
            lon = lon,
            lat = lat,
            radius = radius,
        ).toEntity()
    }

    override suspend fun getPlaceDetails(id: Double): PlaceDetails {
        return remoteDataSource.getPlaceDetails(id = id).toEntity()
    }
}