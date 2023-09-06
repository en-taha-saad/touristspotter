package com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos

import com.google.gson.annotations.SerializedName

data class PlacesDto (
    @SerializedName("features")
    val features: List<FeatureDto>
)