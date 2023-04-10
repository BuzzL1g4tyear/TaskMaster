package com.example.taskmaster.data.storage.room

import com.example.taskmaster.data.entity.TaskEntity

interface TaskStorage {

    suspend fun get(): List<TaskEntity>

    suspend fun insert(task: TaskEntity)

    suspend fun update(task: TaskEntity)

    suspend fun delete(task: TaskEntity)
}