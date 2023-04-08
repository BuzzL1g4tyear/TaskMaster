package com.example.taskmaster.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmaster.domain.model.Task
import com.example.taskmaster.domain.usecase.ViewAllTasksUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val viewAllTasksUseCase: ViewAllTasksUseCase
) : ViewModel() {

    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>>
        get() = _tasks

    fun getAllTasks() {
        viewModelScope.launch {
            _tasks.value = viewAllTasksUseCase.execute()
        }
    }
}