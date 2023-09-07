package com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos

import com.google.gson.annotations.SerializedName

data class PropertiesDto(
    @SerializedName("kinds")
    val kinds: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("xid")
    val xid: String?
)