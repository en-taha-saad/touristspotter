package com.androiddevtaha.touristspotter.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.androiddevtaha.touristspotter.ui.searchListScreen.SearchListScreen
import com.androiddevtaha.touristspotter.ui.theme.TouristspotterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TouristspotterTheme {
                Surface {
                    SearchListScreen()
                }
            }
        }
    }
}