package com.example.taskmaster.presentation.di

import com.example.taskmaster.data.repository.Room.RoomRepository
import com.example.taskmaster.data.storage.room.RoomTaskStorage
import com.example.taskmaster.data.storage.room.TaskStorage
import com.example.taskmaster.domain.repository.TaskRepository
import org.koin.dsl.module

val dataModule = module {

    single<TaskStorage> {
        RoomTaskStorage(context = get())
    }

    single<TaskRepository> {
        RoomRepository(storage = get())
    }
}