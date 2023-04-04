package com.example.taskmaster.domain.repository

import com.example.taskmaster.domain.model.Task

interface TaskRepository {

    suspend fun saveMedicine(task: Task)

    suspend fun getMedicine(): List<Task>

    suspend fun updateMedicine(task: Task)

    suspend fun deleteMedicine(task: Task)
}