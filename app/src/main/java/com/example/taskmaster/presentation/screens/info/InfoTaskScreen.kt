package com.example.taskmaster.presentation.screens.info

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmaster.domain.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InfoScreen(task: Task) {

    val infoViewModel = koinViewModel<InfoViewModel>()

    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }
    val chooseList = listOf("Doesn't matter", "Usually", "Important")

    infoViewModel.id = task.id
    infoViewModel.title = task.title
    infoViewModel.description = task.description
    infoViewModel.priority = task.priority

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                infoViewModel.editTask(
                    task = Task(
                        id = infoViewModel.id,
                        title = infoViewModel.title,
                        description = infoViewModel.description,
                        priority = infoViewModel.priority
                    )
                )
            }
        }) {
            Icon(
                imageVector = Icons.Default.Edit, contentDescription = "Edit"
            )
        }
    }) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Info ${infoViewModel.title}",
                fontSize = 36.sp,
                modifier = Modifier.padding(all = 24.dp)
            )
            OutlinedTextField(value = infoViewModel.title, onValueChange = { title ->
                infoViewModel.setTaskTitle(title)
            }, label = { Text("Task name") })

            OutlinedTextField(value = infoViewModel.description, onValueChange = { description ->
                infoViewModel.setTaskDescription(description)
            }, label = { Text("Task description") })

            Box {
                OutlinedTextField(value = chooseList[infoViewModel.priority], onValueChange = {
                    selectedOption = it
                }, label = { Text("Task priority") }, trailingIcon = {
                    Icon(Icons.Default.MoreVert,
                        contentDescription = "Show menu",
                        Modifier.clickable {
                            expanded = !expanded
                        })
                }, readOnly = true
                )
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    chooseList.forEachIndexed { index, str ->
                        DropdownMenuItem(onClick = {
                            infoViewModel.setTaskPriority(index)
                            selectedOption = chooseList[task.priority]
                            expanded = false
                        }, text = {
                            Text(text = str)
                        })
                    }
                }
            }
        }
    }
}