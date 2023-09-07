package com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos

import com.google.gson.annotations.SerializedName

data class WikipediaExtractsDto(
    @SerializedName("text")
    val text: String?
)