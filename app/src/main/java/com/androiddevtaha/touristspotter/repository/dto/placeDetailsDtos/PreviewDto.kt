package com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos

import com.google.gson.annotations.SerializedName

data class PreviewDto(
    @SerializedName("source")
    val source: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("width")
    val width: Int
)