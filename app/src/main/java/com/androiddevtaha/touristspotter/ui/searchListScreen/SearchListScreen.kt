package com.androiddevtaha.touristspotter.ui.searchListScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.androiddevtaha.touristspotter.viewmodel.PlacesViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@Composable
fun SearchListScreen(viewModel: PlacesViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    val lonMin = 44.2
    val lonMax = 44.5
    val latMin = 43.2
    val latMax = 43.5
    val kinds = ""
    val coroutineScope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()

    LazyColumn(state = lazyListState) {
        items(state.places.size) { place ->
            Text(text = state.places[place].properties.name)
        }
    }
    LaunchedEffect(Unit) {
        viewModel.fetchNextPage(lonMin, lonMax, latMin, latMax, kinds, 20)
        coroutineScope.launch {
            while (isActive) {
                if (lazyListState.layoutInfo.totalItemsCount - 1 == lazyListState.firstVisibleItemIndex + lazyListState.firstVisibleItemScrollOffset) {
                    viewModel.fetchNextPage(lonMin, lonMax, latMin, latMax, kinds, 20)
                }
                delay(300)
            }
        }
    }

}
