package com.example.taskmaster.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.taskmaster.presentation.nav.Screens
import com.example.taskmaster.presentation.nav.navigate
import com.example.taskmaster.presentation.screens.main.MainViewModel
import com.example.taskmaster.presentation.ui.composable.TaskCard
import com.example.taskmaster.presentation.ui.theme.TaskMasterTheme
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {

    TaskMasterTheme {

        val mainViewModel = koinViewModel<MainViewModel>()
        val tasks = mainViewModel.tasks.observeAsState(listOf()).value

        val refreshCount by remember { mutableStateOf(1) }

        LaunchedEffect(key1 = refreshCount) {
            mainViewModel.getAllTasks()
        }

        Scaffold(floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screens.AddTaskScreen.route)
            }) {
                Icon(
                    imageVector = Icons.Default.Add, contentDescription = "Add"
                )
            }

        }) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Tasks", fontSize = 36.sp, modifier = Modifier.padding(all = 24.dp)
                )

                LazyColumn {
                    items(items = tasks) { task ->
                        TaskCard(task = task,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp, horizontal = 24.dp)
                                .clickable {
                                    navController.navigate(
                                        route = Screens.TaskInfoScreen.route,
                                        bundleOf("TASK_KEY" to task),
                                    )
                                })
                    }
                }
            }
        }
    }
}