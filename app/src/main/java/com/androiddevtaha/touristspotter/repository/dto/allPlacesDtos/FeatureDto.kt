package com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos

import com.google.gson.annotations.SerializedName

data class FeatureDto(
    @SerializedName("geometry")
    val geometry: GeometryDto?,
    @SerializedName("properties")
    val properties: PropertiesDto?
)