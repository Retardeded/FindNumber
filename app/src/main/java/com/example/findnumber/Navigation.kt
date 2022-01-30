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

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "10"
                    nullable = true
                }
            )
        ) { entry ->
            entry.arguments?.getString("name")?.let { DetailViewModel(it) }?.let { DetailScreen(viewModel = it) }
        }
        }
}