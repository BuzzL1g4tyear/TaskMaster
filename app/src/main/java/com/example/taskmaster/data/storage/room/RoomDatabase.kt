package com.example.taskmaster.data.storage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskmaster.data.entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDAO(): TaskDAO
}