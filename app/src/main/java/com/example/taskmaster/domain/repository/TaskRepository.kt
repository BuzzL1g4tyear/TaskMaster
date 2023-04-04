package com.example.taskmaster.domain.repository

import com.example.taskmaster.domain.model.Task

interface TaskRepository {
    suspend fun getTasks(): List<Task>

    suspend fun saveTask(task: Task)

    suspend fun updateTask(task: Task)

    suspend fun deleteTask(task: Task)

}