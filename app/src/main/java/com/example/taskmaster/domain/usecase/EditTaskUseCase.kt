package com.example.taskmaster.domain.usecase

import com.example.taskmaster.domain.model.Task
import com.example.taskmaster.domain.repository.TaskRepository

class EditTaskUseCase(private val repository: TaskRepository) {

    suspend fun execute(task: Task) {
        repository.updateTask(task = task)
    }

}