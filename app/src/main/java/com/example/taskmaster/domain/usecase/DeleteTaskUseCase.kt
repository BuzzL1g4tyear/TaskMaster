package com.example.taskmaster.domain.usecase

import com.example.taskmaster.domain.model.Task
import com.example.taskmaster.domain.repository.TaskRepository

class DeleteTaskUseCase(private val repository: TaskRepository) {

    suspend fun execute(task: Task) {
        repository.deleteTask(task = task)
    }

}