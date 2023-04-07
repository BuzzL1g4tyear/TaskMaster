package com.example.taskmaster.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.taskmaster.presentation.nav.Screens
import com.example.taskmaster.presentation.screens.main.MainViewModel
import com.example.taskmaster.presentation.ui.composable.TaskCard
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {

    val mainViewModel = koinViewModel<MainViewModel>()

    val tasks = mainViewModel.tasks.observeAsState(listOf()).value

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate(Screens.AddTaskScreen.route)
        }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }

    }) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Tasks", fontSize = 36.sp, modifier = Modifier.padding(all = 24.dp)
            )
            tasks.forEach { task ->

                TaskCard(
                    task = task,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 24.dp)
                )
            }
        }
    }
}