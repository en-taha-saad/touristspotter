package com.androiddevtaha.touristspotter.viewmodel

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import com.androiddevtaha.touristspotter.viewmodel.base.BaseUiEffect
import com.androiddevtaha.touristspotter.viewmodel.base.BaseViewModel
import com.androiddevtaha.touristspotter.entites.places.Feature
import com.androiddevtaha.touristspotter.usecase.GetPlacesUseCase
import com.androiddevtaha.touristspotter.viewmodel.base.ErrorUiState
import com.androiddevtaha.touristspotter.viewmodel.uiStates.SearchListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlacesViewModel @Inject constructor(
    private val getPlaces: GetPlacesUseCase
) : BaseViewModel<SearchListUiState, UiEffect>(SearchListUiState()) {
    private val lonMin = 44.2
    private val lonMax = 44.5
    private val latMin = 43.2
    private val latMax = 43.5
    private val kinds = ""
    private val name = ""
    private var currentLimit = 10

    fun fetchIfNeeded(lazyListState: LazyListState) {
        val shouldFetch =
            (lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                ?: 0) > lazyListState.layoutInfo.totalItemsCount - 5
        if (shouldFetch && !_state.value.isFetching) {
            _state.update { SearchListUiState(isFetching = true) }
            if (currentLimit != 10) {
                currentLimit += 10
            }
            fetchNextPage(lonMin, lonMax, latMin, latMax, kinds, name, currentLimit)
            _state.update {
                SearchListUiState(isFetching = false)
            }
        }

    }


    private fun fetchNextPage(
        lonMin: Double,
        lonMax: Double,
        latMin: Double,
        latMax: Double,
        kinds: String,
        name: String,
        limit: Int
    ) {
        if (currentLimit == 10) {
            _state.update { SearchListUiState(isLoading = true, error = null) }
        }
        tryToExecute(
            execute = {
                getPlaces.invoke(
                    lonMin,
                    lonMax,
                    latMin,
                    latMax,
                    kinds,
                    name,
                    limit
                )
            },
            onSuccessWithData = ::onSuccess,
            onError = ::onError,
        )
    }

    private fun onSuccess(places: List<Feature>) {
        Log.e("taha", "onSuccess = ${places.size}")
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