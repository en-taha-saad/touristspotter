package com.androiddevtaha.touristspotter.usecase

import com.androiddevtaha.touristspotter.entites.placeDetails.PlaceDetails
import com.androiddevtaha.touristspotter.entites.places.Places

interface PlacesRepository {
    suspend fun getAllPlaces(
        lonMin: Double,
        lonMax: Double,
        latMin: Double,
        latMax: Double,
        kinds: String,
        limit: Int,
    ): Places

    suspend fun getNearestPlaces(
        lon: Double,
        lat: Double,
        radius: Int,
    ): Places

    suspend fun getPlaceDetails(id: Double): PlaceDetails

}