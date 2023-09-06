package com.androiddevtaha.touristspotter.remote.source

import com.androiddevtaha.touristspotter.remote.service.OpenTripMapApiService
import com.androiddevtaha.touristspotter.repository.RemoteDataSource
import com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos.PlacesDto
import com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos.PlaceDetailsDto
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val openTripMapApiService: OpenTripMapApiService,
) : RemoteDataSource {
    override suspend fun getAllPlaces(
        lonMin: Double,
        lonMax: Double,
        latMin: Double,
        latMax: Double,
        kinds: String,
        limit: Int
    ): PlacesDto {
        return openTripMapApiService.getAllPlaces(
            lonMin = lonMin,
            lonMax = lonMax,
            latMin = latMin,
            latMax = latMax,
            kinds = kinds,
            limit = limit,
        )
    }

    override suspend fun getNearestPlaces(lon: Double, lat: Double, radius: Int): PlacesDto {
        return openTripMapApiService.getNearestPlaces(
            lon = lon,
            lat = lat,
            radius = radius,
        )
    }

    override suspend fun getPlaceDetails(id: Double): PlaceDetailsDto {
        return openTripMapApiService.getPlaceDetails(
            id = id,
        )
    }

}