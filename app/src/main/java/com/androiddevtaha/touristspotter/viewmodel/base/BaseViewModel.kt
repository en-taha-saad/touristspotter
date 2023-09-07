package com.androiddevtaha.touristspotter.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevtaha.touristspotter.entites.error.NetworkException
import com.androiddevtaha.touristspotter.entites.error.NoInternetException
import com.androiddevtaha.touristspotter.entites.error.NullResultException
import com.androiddevtaha.touristspotter.entites.error.PlacesException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState : BaseUiState, UiEffect>(state: UiState) :
    ViewModel() {

    protected val _state = MutableStateFlow(state)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<UiEffect>()
    val effect = _effect.asSharedFlow()

    fun <T> tryToExecute(
        execute: suspend () -> T,
        onSuccessWithData: (T) -> Unit = {},
        onSuccessWithoutData: () -> Unit = {},
        onError: (error: ErrorUiState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = execute()
                onSuccessWithData(result)
                onSuccessWithoutData()
            } catch (e: NullResultException) {
                onError(NullResultErrorState(e.message.toString()))
            } catch (e: NetworkException) {
                onError(NetworkErrorState(e.message.toString()))
            } catch (e: PlacesException) {
                onError(ErrorUiState(e.message.toString()))
            } catch (e: NoInternetException) {
                onError(NetworkErrorState(e.message.toString()))
            } catch (e: Exception) {
                onError(ErrorUiState(e.message.toString()))
            }
        }
    }

    protected fun sendUiEffect(uiEffect: UiEffect) {
        viewModelScope.launch(Dispatchers.IO) {
            _effect.emit(uiEffect)
        }
    }
}

interface BaseUiState

interface BaseUiEffect
