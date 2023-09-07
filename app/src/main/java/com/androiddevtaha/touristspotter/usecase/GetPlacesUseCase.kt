package com.androiddevtaha.touristspotter.usecase

import com.androiddevtaha.touristspotter.entites.places.Feature
import com.androiddevtaha.touristspotter.entites.places.Places
import javax.inject.Inject

class GetPlacesUseCase @Inject constructor(
    private val placesRepository: PlacesRepository
) {
    private val places = mutableListOf<Feature>()
    private var offset = 0

    suspend fun invoke(
        lonMin: Double,
        lonMax: Double,
        latMin: Double,
        latMax: Double,
        kinds: String,
        limit: Int
    ): List<Feature> {
        val newPlaces =
            placesRepository.getAllPlaces(lonMin, lonMax, latMin, latMax, kinds, limit).features
        places.addAll(newPlaces.filter { it.properties.xid !in places.map { place -> place.properties.xid } })
        offset = places.size
        return places
    }
}
