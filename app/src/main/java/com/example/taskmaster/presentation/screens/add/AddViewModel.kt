package com.example.taskmaster.presentation.screens.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.taskmaster.domain.model.Task
import com.example.taskmaster.domain.usecase.NewTaskUseCase

class AddViewModel(private val newTaskUseCase: NewTaskUseCase) : ViewModel() {

    var title by mutableStateOf("")
        private set

    fun setTaskTitle(input: String) {
        title = input
    }

    var description by mutableStateOf("")
        private set

    fun setTaskDescription(input: String) {
        description = input
    }

    var priority by mutableStateOf(0)
        private set

    fun setTaskPriority(input: Int) {
        priority = input
    }

    suspend fun addTask(task: Task) {
        newTaskUseCase.execute(task = task)
    }

}