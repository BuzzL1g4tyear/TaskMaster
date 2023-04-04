package com.example.taskmaster.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Screens(val route: String) {
    object MainScreen : Screens(route = "main")
    object EditTaskScreen : Screens(route = "edit")
    object TaskInfoScreen : Screens(route = "info")
}

@Composable
fun SetNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ) {
        composable(route = Screens.MainScreen.route) {

        }

        composable(route = Screens.EditTaskScreen.route) {

        }

        composable(route = Screens.TaskInfoScreen.route) {

        }
    }

}