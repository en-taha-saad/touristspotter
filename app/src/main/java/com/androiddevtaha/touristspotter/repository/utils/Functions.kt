package com.androiddevtaha.touristspotter.repository.utils

import com.androiddevtaha.touristspotter.entites.placeDetails.Address
import com.androiddevtaha.touristspotter.entites.placeDetails.Point
import com.androiddevtaha.touristspotter.entites.placeDetails.Preview
import com.androiddevtaha.touristspotter.entites.placeDetails.WikipediaExtracts
import com.androiddevtaha.touristspotter.entites.places.Geometry
import com.androiddevtaha.touristspotter.entites.places.Properties

fun Geometry?.orEmpty() = this ?: Geometry(emptyList())
fun Properties?.orEmpty() = this ?: Properties("", "", "")
fun Double?.orEmpty() = this ?: 0.0
fun Int?.orEmpty() = this ?: 0
fun Address?.orEmpty() = this ?: Address("", "", "", "", "", "", "", "")
fun Point?.orEmpty() = this ?: Point(0.0, 0.0)
fun Preview?.orEmpty() = this ?: Preview("", 0, 0)
fun WikipediaExtracts?.orEmpty() = this ?: WikipediaExtracts("")

