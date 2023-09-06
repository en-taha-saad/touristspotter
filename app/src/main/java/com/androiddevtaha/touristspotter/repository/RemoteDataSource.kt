package com.androiddevtaha.touristspotter.repository

import com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos.PlacesDto
import com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos.PlaceDetailsDto

interface RemoteDataSource {
    suspend fun getAllPlaces(
        lonMin: Double,
        lonMax: Double,
        latMin: Double,
        latMax: Double,
        kinds: String,
        limit: Int,
    ): PlacesDto

    suspend fun getNearestPlaces(
        lon: Double,
        lat: Double,
        radius: Int,
    ): PlacesDto

    suspend fun getPlaceDetails(id: Double): PlaceDetailsDto
}