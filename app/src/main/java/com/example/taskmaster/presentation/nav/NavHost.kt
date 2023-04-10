package com.example.taskmaster.presentation.nav

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.taskmaster.domain.model.Task
import com.example.taskmaster.presentation.screens.add.AddScreen
import com.example.taskmaster.presentation.screens.info.InfoScreen
import com.example.taskmaster.presentation.screens.main.MainScreen

sealed class Screens(val route: String) {
    object MainScreen : Screens(route = "main")
    object AddTaskScreen : Screens(route = "add")
    object TaskInfoScreen : Screens(route = "info")
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun SetNavHost(navController: NavHostController) {

    NavHost(
        navController = navController, startDestination = Screens.MainScreen.route
    ) {
        composable(
            route = Screens.MainScreen.route
        ) {
            MainScreen(navController = navController)
        }

        composable(
            route = Screens.AddTaskScreen.route
        ) {
            AddScreen()
        }

        composable(
            route = Screens.TaskInfoScreen.route
        ) {
            navController.previousBackStackEntry?.savedStateHandle?.get<Task>("KEY_TASK")?.let {
                InfoScreen(task = it)
            }
        }
    }

}