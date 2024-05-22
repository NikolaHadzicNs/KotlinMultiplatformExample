package com.nikola.kotlinmultiplatformexample.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nikola.kotlinmultiplatformexample.data.local.entity.TodoEntity

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos")
    suspend fun getAll(): List<TodoEntity>

    @Insert
    suspend fun insert(todo: TodoEntity)
}