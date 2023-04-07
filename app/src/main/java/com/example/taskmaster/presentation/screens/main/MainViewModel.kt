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

    private val viewModelTasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>>
        get() = viewModelTasks

    init {
        getAllTasks()
    }

    private fun getAllTasks() {
        viewModelScope.launch {
            viewAllTasksUseCase.execute().let {
                viewModelTasks.postValue(it)
            }
        }
    }
}