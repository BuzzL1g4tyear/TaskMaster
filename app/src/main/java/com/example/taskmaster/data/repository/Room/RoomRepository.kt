package com.example.taskmaster.data.repository.Room

import com.example.taskmaster.data.entity.TaskEntity
import com.example.taskmaster.data.storage.room.TaskStorage
import com.example.taskmaster.domain.model.Task
import com.example.taskmaster.domain.repository.TaskRepository

class RoomRepository(private val storage: TaskStorage) : TaskRepository {

    override suspend fun getTasks(): List<Task> {
        return toDomain(storage.get())
    }

    override suspend fun saveTask(task: Task) {
        storage.insert(toStorage(task))
    }

    override suspend fun updateTask(task: Task) {
        storage.update(toStorage(task = task))
    }

    override suspend fun deleteTask(task: Task) {
        storage.delete(toStorage(task = task))
    }

    private fun toStorage(task: Task): TaskEntity {
        return TaskEntity(
            Id = task.id,
            title = task.title,
            description = task.description,
            priority = task.priority
        )
    }

    private fun toDomain(tasksList: List<TaskEntity>): List<Task> {

        val list = mutableListOf<Task>()

        for (task in tasksList) {
            val t = Task(
                id = task.Id,
                title = task.title,
                description = task.description,
                priority = task.priority
            )
            list.add(t)
        }
        return list
    }
}