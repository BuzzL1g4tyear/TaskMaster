package com.example.taskmaster.presentation.di

import com.example.taskmaster.data.repository.Room.RoomRepository
import com.example.taskmaster.data.storage.room.RoomTaskStorage
import org.koin.dsl.module

val appModule = module {

    single<RoomTaskStorage> {
        RoomTaskStorage(context = get())
    }

    single<RoomRepository> {
        RoomRepository(storage = get())
    }
}