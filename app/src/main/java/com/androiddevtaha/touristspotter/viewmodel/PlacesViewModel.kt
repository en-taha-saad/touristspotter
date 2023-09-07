package com.androiddevtaha.touristspotter.viewmodel

import com.androiddevtaha.touristspotter.viewmodel.base.BaseUiEffect
import com.androiddevtaha.touristspotter.viewmodel.base.BaseViewModel
import com.androiddevtaha.touristspotter.entites.places.Feature
import com.androiddevtaha.touristspotter.usecase.GetPlacesUseCase
import com.androiddevtaha.touristspotter.viewmodel.base.ErrorUiState
import com.androiddevtaha.touristspotter.viewmodel.uiStates.SearchListUiState
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class PlacesViewModel @Inject constructor(
    private val getPlaces: GetPlacesUseCase
) : BaseViewModel<SearchListUiState, UiEffect>(SearchListUiState()) {

    fun fetchNextPage(
        lonMin: Double,
        lonMax: Double,
        latMin: Double,
        latMax: Double,
        kinds: String,
        limit: Int
    ) {
        _state.update { SearchListUiState(isLoading = true, error = null) }
        tryToExecute(
            execute = { getPlaces.invoke(lonMin, lonMax, latMin, latMax, kinds, limit) },
            onSuccessWithData = ::onSuccess,
            onError = ::onError,
        )
    }

    private fun onSuccess(places: List<Feature>) {
        _state.update {
            SearchListUiState(
                places = places,
                isLoading = false,
                error = null,
            )
        }
    }

    private fun onError(error: ErrorUiState) {
        _state.update {
            SearchListUiState(
                places = emptyList(),
                isLoading = false,
                error = error,
            )
        }
    }


}

class UiEffect() : BaseUiEffect {}