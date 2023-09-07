package com.androiddevtaha.touristspotter.entites.placeDetails


data class PlaceDetails(
    val xid: String,
    val name: String,
    val address: Address,
    val kinds: String,
    val point: Point,
    val wikipedia: String,
    val preview: Preview,
    val wikipediaExtracts: WikipediaExtracts
)