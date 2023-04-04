package com.example.taskmaster.data.repository.Room

import com.example.taskmaster.data.entity.TaskEntity
import com.example.taskmaster.data.storage.room.TaskStorage
import com.example.taskmaster.domain.model.Task
import com.example.taskmaster.domain.repository.TaskRepository

class RoomRepository(private val storage: TaskStorage) : TaskRepository {

    override suspend fun getMedicine(): List<Task> {
        return toDomain(storage.get())
    }

    override suspend fun saveMedicine(task: Task) {
        storage.insert(toStorage(task))
    }

    override suspend fun updateMedicine(task: Task) {
        storage.update(toStorage(task = task))
    }

    override suspend fun deleteMedicine(task: Task) {
        storage.delete(toStorage(task = task))
    }

    private fun toStorage(task: Task): TaskEntity {
        return TaskEntity(
            title = task.title, description = task.description, priority = task.priority
        )
    }

    private fun toDomain(tasksList: List<TaskEntity>): List<Task> {

        val list = mutableListOf<Task>()

        for (task in tasksList) {
            val t = Task(
                title = task.title, description = task.description, priority = task.priority
            )
            list.add(t)
        }
        return list
    }
}