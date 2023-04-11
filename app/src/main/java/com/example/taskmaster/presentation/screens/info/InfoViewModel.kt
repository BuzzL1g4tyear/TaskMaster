package com.example.taskmaster.presentation.screens.info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.taskmaster.domain.model.Task
import com.example.taskmaster.domain.usecase.DeleteTaskUseCase
import com.example.taskmaster.domain.usecase.EditTaskUseCase

class InfoViewModel(
    private val editTaskUseCase: EditTaskUseCase, private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {
    var id by mutableStateOf(0)

    var title by mutableStateOf("")

    fun setTaskTitle(input: String) {
        title = input
    }

    var description by mutableStateOf("")

    fun setTaskDescription(input: String) {
        description = input
    }

    var priority by mutableStateOf(0)

    fun setTaskPriority(input: Int) {
        priority = input
    }

    suspend fun editTask(task: Task) {
        editTaskUseCase.execute(task = task)
    }

    suspend fun deleteTask(task: Task) {
        deleteTaskUseCase.execute(task = task)
    }
}