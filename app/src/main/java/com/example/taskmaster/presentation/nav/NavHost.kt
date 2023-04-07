package com.example.taskmaster.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.taskmaster.presentation.screens.MainScreen
import com.example.taskmaster.presentation.screens.add.AddScreen

sealed class Screens(val route: String) {
    object MainScreen : Screens(route = "main")
    object EditTaskScreen : Screens(route = "edit")
    object AddTaskScreen : Screens(route = "add")
    object TaskInfoScreen : Screens(route = "info")
}

@Composable
fun SetNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ) {
        composable(route = Screens.MainScreen.route) {
            MainScreen(navController = navController)
        }

        composable(route = Screens.AddTaskScreen.route) {
            AddScreen()
        }

        composable(route = Screens.EditTaskScreen.route) {

        }

        composable(route = Screens.TaskInfoScreen.route) {

        }
    }

}