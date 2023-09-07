package com.androiddevtaha.touristspotter.viewmodel.base

open class ErrorUiState(val message: String = "Error occurred!")
class NullResultErrorState(message: String) : ErrorUiState(message)
class NetworkErrorState(message: String) : ErrorUiState(message)
