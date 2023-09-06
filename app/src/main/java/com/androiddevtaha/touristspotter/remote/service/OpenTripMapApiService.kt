package com.androiddevtaha.touristspotter.remote.service

import com.androiddevtaha.touristspotter.BuildConfig
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
        @Query("lon_min") lonMin: Double,
        @Query("lon_max") lonMax: Double,
        @Query("lat_min") latMin: Double,
        @Query("lat_max") latMax: Double,
        @Query("kinds") kinds: String,
        @Query("limit") limit: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): Response<PlacesDto>

    @GET("{lang}/places/bbox")
    suspend fun getNearestPlaces(
        @Path("lang") language: String = "en",
        @Query("lon") lon: Double,
        @Query("lat") lat: Double,
        @Query("radius") radius: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): Response<PlacesDto>

    @GET("{lang}/places/xid/{xid}")
    suspend fun getPlaceDetails(
        @Path("lang") language: String = "en",
        @Path("xid") id: Double,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): Response<PlaceDetailsDto>


}