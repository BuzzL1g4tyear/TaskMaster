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

    override suspend fun insert(medicine: TaskEntity) {
        taskDAO.insert(task = medicine)
    }

    override suspend fun update(medicine: TaskEntity) {
        taskDAO.update(task = medicine)
    }

    override suspend fun delete(medicine: TaskEntity) {
        taskDAO.delete(task = medicine)
    }
}