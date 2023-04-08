package com.example.taskmaster.presentation.screens.add

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
fun AddScreen() {

    val addViewModel = koinViewModel<AddViewModel>()

    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }
    val chooseList = listOf("Doesn't matter", "Usually", "Important")

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                addViewModel.addTask(
                    task = Task(
                        title = addViewModel.title,
                        description = addViewModel.description,
                        priority = addViewModel.priority
                    )
                )
            }
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
                text = "Add", fontSize = 36.sp, modifier = Modifier.padding(all = 24.dp)
            )

            OutlinedTextField(value = addViewModel.title, onValueChange = { title ->
                addViewModel.setTaskTitle(title)
            }, label = { Text("Task name") })

            OutlinedTextField(value = addViewModel.description, onValueChange = { description ->
                addViewModel.setTaskDescription(description)
            }, label = { Text("Task description") })

            Box {
                OutlinedTextField(
                    value = selectedOption,
                    onValueChange = {
                        selectedOption = it
                    },
                    label = { Text("Task priority") },
                    trailingIcon = {
                        Icon(
                            Icons.Default.MoreVert,
                            contentDescription = "Show menu",
                            Modifier.clickable {
                                expanded = !expanded
                            })
                    },
                    readOnly = true
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    chooseList.forEachIndexed { index, str ->
                        DropdownMenuItem(onClick = {
                            addViewModel.setTaskPriority(index)
                            selectedOption = str
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