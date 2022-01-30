package com.example.findnumber

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.findnumber.presentation.detail_screen.DetailViewModel
import com.example.findnumber.presentation.main_screen.DetailScreen
import com.example.findnumber.presentation.main_screen.MainScreen
import com.example.findnumber.common.Constants

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{${Constants.PARAM_NAME}}",
            arguments = listOf(
                navArgument(Constants.PARAM_NAME) {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            entry.arguments?.getString(Constants.PARAM_NAME)?.let { DetailViewModel(it) }?.let { DetailScreen(viewModel = it) }
        }
        }
}