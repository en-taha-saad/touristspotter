package com.androiddevtaha.touristspotter.ui.searchListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.androiddevtaha.touristspotter.viewmodel.PlacesViewModel

@Composable
fun SearchListScreen(viewModel: PlacesViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    val lazyListState = rememberLazyListState()
    if (state.isLoading) Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
    if (!state.isLoading && state.error != null) Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = state.error!!.message)
    }

    if (!state.isLoading && state.error == null) {
        LazyColumn(state = lazyListState) {
            items(state.places.size) { place ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                ) {
                    Text(
                        text = state.places[place].properties.name,
                        modifier = Modifier
                            .height(100.dp)
                            .background(Color.Gray),
                    )
                    if (state.isFetching) CircularProgressIndicator()
                }
            }
        }
        LaunchedEffect(lazyListState) {
            snapshotFlow { lazyListState.isScrollInProgress }.collect {
                    viewModel.fetchIfNeeded(lazyListState)
            }
        }
    }
}
