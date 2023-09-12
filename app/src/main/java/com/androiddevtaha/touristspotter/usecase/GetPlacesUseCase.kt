package com.androiddevtaha.touristspotter.usecase

import com.androiddevtaha.touristspotter.entites.places.Feature
import javax.inject.Inject

class GetPlacesUseCase @Inject constructor(
    private val placesRepository: PlacesRepository
) {
    private val places = mutableListOf<Feature>()

    suspend fun invoke(
        lonMin: Double,
        lonMax: Double,
        latMin: Double,
        latMax: Double,
        kinds: String,
        name: String,
        limit: Int
    ): List<Feature> {
        val newPlaces = placesRepository.getAllPlaces(
            lonMin,
            lonMax,
            latMin,
            latMax,
            kinds,
            name,
            limit
        ).features
        places.addAll(newPlaces.takeLast(10))
        return places
    }
}
