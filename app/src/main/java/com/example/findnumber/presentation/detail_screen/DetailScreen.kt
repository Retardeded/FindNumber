package com.example.findnumber.presentation.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.findnumber.presentation.detail_screen.DetailViewModel

@Composable
fun DetailScreen(viewModel: DetailViewModel) {

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
            ) {
        Text(text = "${viewModel.state.value}")
    }
}