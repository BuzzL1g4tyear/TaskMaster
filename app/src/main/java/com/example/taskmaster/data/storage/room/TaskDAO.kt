package com.example.taskmaster.data.storage.room

import androidx.room.*
import com.example.taskmaster.data.entity.TaskEntity

@Dao
interface TaskDAO {

    @Query("SELECT * FROM MedicineEntity")
    suspend fun getAll(): List<TaskEntity>

    @Insert
    suspend fun insert(task: TaskEntity)

    @Update
    suspend fun update(task: TaskEntity)

    @Delete
    suspend fun delete(task: TaskEntity)

}