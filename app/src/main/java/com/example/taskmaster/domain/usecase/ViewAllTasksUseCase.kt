package com.example.taskmaster.domain.usecase

import com.example.taskmaster.domain.model.Task
import com.example.taskmaster.domain.repository.TaskRepository

class ViewAllTasksUseCase(private val repository: TaskRepository) {

    suspend fun execute(task: Task): List<Task> {
        return repository.getTasks()
    }

}