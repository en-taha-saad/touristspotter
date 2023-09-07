package com.androiddevtaha.touristspotter.viewmodel.uiStates

import com.androiddevtaha.touristspotter.viewmodel.base.BaseUiState
import com.androiddevtaha.touristspotter.entites.places.Feature
import com.androiddevtaha.touristspotter.viewmodel.base.ErrorUiState

data class SearchListUiState(
    val places: List<Feature> = emptyList(),
    val isLoading: Boolean = false,
    val error: ErrorUiState? = null,
) : BaseUiState