package com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos

import com.google.gson.annotations.SerializedName

data class AddressDto(
    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("county")
    val county: String,
    @SerializedName("suburb")
    val suburb: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("postcode")
    val postcode: String,
    @SerializedName("city_district")
    val cityDistrict: String,
    @SerializedName("neighbourhood")
    val neighbourhood: String
)