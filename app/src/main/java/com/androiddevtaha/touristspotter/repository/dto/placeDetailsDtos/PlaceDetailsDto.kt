package com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos

import com.google.gson.annotations.SerializedName

data class PlaceDetailsDto(
    @SerializedName("xid")
    val xid: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("address")
    val address: AddressDto?,
    @SerializedName("kinds")
    val kinds: String?,
    @SerializedName("point")
    val point: PointDto?,
    @SerializedName("wikipedia")
    val wikipedia: String?,
    @SerializedName("preview")
    val preview: PreviewDto?,
    @SerializedName("wikipedia_extracts")
    val wikipediaExtracts: WikipediaExtractsDto?
)