package com.androiddevtaha.touristspotter.remote.source

import com.androiddevtaha.touristspotter.entites.error.BadRequestException
import com.androiddevtaha.touristspotter.entites.error.NoInternetException
import com.androiddevtaha.touristspotter.entites.error.NotFoundException
import com.androiddevtaha.touristspotter.entites.error.NullResultException
import com.androiddevtaha.touristspotter.entites.error.ServerException
import com.androiddevtaha.touristspotter.entites.error.UnknownException
import com.androiddevtaha.touristspotter.remote.service.OpenTripMapApiService
import com.androiddevtaha.touristspotter.repository.RemoteDataSource
import com.androiddevtaha.touristspotter.repository.dto.allPlacesDtos.PlacesDto
import com.androiddevtaha.touristspotter.repository.dto.placeDetailsDtos.PlaceDetailsDto
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val openTripMapApiService: OpenTripMapApiService,
) : RemoteDataSource {
    override suspend fun getAllPlaces(
        lonMin: Double,
        lonMax: Double,
        latMin: Double,
        latMax: Double,
        kinds: String,
        name: String,
        limit: Int
    ): PlacesDto {
        return wrapApiResponse {
            openTripMapApiService.getAllPlaces(
                lonMin = lonMin,
                lonMax = lonMax,
                latMin = latMin,
                latMax = latMax,
                kinds = kinds.ifEmpty { null },
                name = name.ifEmpty { null },
                limit = limit,
            )
        }
    }

    override suspend fun getNearestPlaces(
        lon: Double,
        lat: Double,
        name: String,
        kinds: String,
        radius: Int,
    ): PlacesDto {
        return wrapApiResponse {
            openTripMapApiService.getNearestPlaces(
                lon = lon,
                lat = lat,
                radius = radius,
                kinds = kinds.ifEmpty { null },
                name = name.ifEmpty { null },
            )
        }
    }

    override suspend fun getPlaceDetails(id: Double): PlaceDetailsDto {
        return wrapApiResponse {
            openTripMapApiService.getPlaceDetails(
                id = id,
            )
        }
    }

    private suspend fun <T> wrapApiResponse(
        request: suspend () -> Response<T>
    ): T {
        try {
            val response = request()
            if (response.isSuccessful) {
                return response.body() ?: throw NullResultException("No data")
            } else {
                throw when (response.code()) {
                    400 -> BadRequestException(response.message())
                    404 -> NotFoundException("Not found")
                    500 -> ServerException("Server error")
                    else -> UnknownException("Unknown error")
                }
            }
        } catch (e: UnknownHostException) {
            throw NoInternetException("no Internet")
        } catch (io: IOException) {
            throw NoInternetException(io.message)
        }
    }

}