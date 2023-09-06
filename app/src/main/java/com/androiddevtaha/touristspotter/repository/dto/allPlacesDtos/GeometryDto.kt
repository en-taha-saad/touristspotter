package com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos

import com.google.gson.annotations.SerializedName

data class GeometryDto(
    @SerializedName("coordinates")
    val coordinates: List<Double>
)