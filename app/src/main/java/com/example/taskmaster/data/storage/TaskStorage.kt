package com.example.taskmaster.data.storage.room

import com.example.taskmaster.data.entity.TaskEntity

interface TaskStorage {

    suspend fun get(): List<TaskEntity>

    suspend fun insert(medicine: TaskEntity)

    suspend fun update(medicine: TaskEntity)

    suspend fun delete(medicine: TaskEntity)
}