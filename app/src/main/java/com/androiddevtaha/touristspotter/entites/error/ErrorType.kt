package com.androiddevtaha.touristspotter.entites.error

open class PlacesException(message: String?) : Exception(message)

class NullResultException(message: String?) : PlacesException(message)
class BadRequestException(message: String?) : PlacesException(message)
class NotFoundException(message: String?) : PlacesException(message)
class UnknownException(message: String?) : PlacesException(message)
open class NetworkException(message: String?) : PlacesException(message)
class NoInternetException(message: String?) : NetworkException(message)
class ServerException(message: String?) : NetworkException(message)
