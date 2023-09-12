package com.androiddevtaha.touristspotter.remote.service

import com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos.PlacesDto
import com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos.PlaceDetailsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenTripMapApiService {
    @GET("{lang}/places/bbox")
    suspend fun getAllPlaces(
        @Path("lang") language: String = "en",
        @Query("lon_min") lonMin: Double? = null,
        @Query("lon_max") lonMax: Double? = null,
        @Query("lat_min") latMin: Double? = null,
        @Query("lat_max") latMax: Double? = null,
        @Query("kinds") kinds: String? = null,
        @Query("name") name: String? = null,
        @Query("limit") limit: Int? = null,
    ): Response<PlacesDto>

    @GET("{lang}/places/bbox")
    suspend fun getNearestPlaces(
        @Path("lang") language: String = "en",
        @Query("lon") lon: Double? = null,
        @Query("lat") lat: Double? = null,
        @Query("kinds") kinds: String? = null,
        @Query("name") name: String? = null,
        @Query("radius") radius: Int? = null,
    ): Response<PlacesDto>

    @GET("{lang}/places/xid/{xid}")
    suspend fun getPlaceDetails(
        @Path("lang") language: String = "en",
        @Path("xid") id: Double? = null,
    ): Response<PlaceDetailsDto>


}