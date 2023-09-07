package com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos

import com.google.gson.annotations.SerializedName

data class PointDto(
    @SerializedName("lon")
    val lon: Double?,
    @SerializedName("lat")
    val lat: Double?
)