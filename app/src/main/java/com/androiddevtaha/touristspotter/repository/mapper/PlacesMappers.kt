package com.androiddevtaha.touristspotter.repository.mapper

import com.androiddevtaha.touristspotter.entites.placeDetails.Address
import com.androiddevtaha.touristspotter.entites.placeDetails.PlaceDetails
import com.androiddevtaha.touristspotter.entites.placeDetails.Point
import com.androiddevtaha.touristspotter.entites.placeDetails.Preview
import com.androiddevtaha.touristspotter.entites.placeDetails.WikipediaExtracts
import com.androiddevtaha.touristspotter.entites.places.Feature
import com.androiddevtaha.touristspotter.entites.places.Geometry
import com.androiddevtaha.touristspotter.entites.places.Places
import com.androiddevtaha.touristspotter.entites.places.Properties
import com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos.FeatureDto
import com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos.GeometryDto
import com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos.PlacesDto
import com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos.PropertiesDto
import com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos.AddressDto
import com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos.PlaceDetailsDto
import com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos.PointDto
import com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos.PreviewDto
import com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos.WikipediaExtractsDto
import com.androiddevtaha.touristspotter.repository.utils.orEmpty


fun PlacesDto.toEntity(): Places {
    return Places(
        features = this.features?.map { it.toEntity() }.orEmpty()
    )
}

fun PlaceDetailsDto.toEntity(): PlaceDetails {
    return PlaceDetails(
        xid = this.xid.orEmpty(),
        name = this.name.orEmpty(),
        address = this.address?.toEntity().orEmpty(),
        kinds = this.kinds.orEmpty(),
        point = this.point?.toEntity().orEmpty(),
        wikipedia = this.wikipedia.orEmpty(),
        preview = this.preview?.toEntity().orEmpty(),
        wikipediaExtracts = this.wikipediaExtracts?.toEntity().orEmpty()
    )
}

fun FeatureDto.toEntity(): Feature {
    return Feature(
        geometry = this.geometry?.toEntity().orEmpty(),
        properties = this.properties?.toEntity().orEmpty()
    )
}

fun GeometryDto.toEntity(): Geometry {
    return Geometry(
        coordinates = this.coordinates.orEmpty()
    )
}

fun PropertiesDto.toEntity(): Properties {
    return Properties(
        kinds = this.kinds.orEmpty(),
        name = this.name.orEmpty(),
        xid = this.xid.orEmpty()
    )
}

fun AddressDto.toEntity(): Address {
    return Address(
        city = this.city.orEmpty(),
        state = this.state.orEmpty(),
        county = this.county.orEmpty(),
        suburb = this.suburb.orEmpty(),
        country = this.country.orEmpty(),
        postcode = this.postcode.orEmpty(),
        cityDistrict = this.cityDistrict.orEmpty(),
        neighbourhood = this.neighbourhood.orEmpty()
    )
}

fun PointDto.toEntity(): Point {
    return Point(
        lon = this.lon.orEmpty(),
        lat = this.lat.orEmpty()
    )
}

fun PreviewDto.toEntity(): Preview {
    return Preview(
        source = this.source.orEmpty(),
        height = this.height.orEmpty(),
        width = this.width.orEmpty()
    )
}

fun WikipediaExtractsDto.toEntity(): WikipediaExtracts {
    return WikipediaExtracts(
        text = this.text.orEmpty()
    )
}
