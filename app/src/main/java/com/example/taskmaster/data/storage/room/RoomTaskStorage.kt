package com.example.taskmaster.data.storage.room

import android.content.Context
import androidx.room.Room
import com.example.taskmaster.data.entity.TaskEntity

class RoomTaskStorage(context: Context): TaskStorage {
    private val database = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "TaskDatabase"
    ).build()

    private val taskDAO = database.taskDAO()

    override suspend fun get(): List<TaskEntity> {
        return taskDAO.getAll()
    }

    override suspend fun insert(task: TaskEntity) {
        taskDAO.insert(task = task)
    }

    override suspend fun update(task: TaskEntity) {
        taskDAO.update(task = task)
    }

    override suspend fun delete(task: TaskEntity) {
        taskDAO.delete(task = task)
    }
}