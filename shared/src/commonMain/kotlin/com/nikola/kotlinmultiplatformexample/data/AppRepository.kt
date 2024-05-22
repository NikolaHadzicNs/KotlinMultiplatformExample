package com.nikola.kotlinmultiplatformexample.data

import com.nikola.kotlinmultiplatformexample.data.local.AppDatabase
import com.nikola.kotlinmultiplatformexample.data.local.entity.TodoEntity

class AppRepository(
    private val database: AppDatabase
) {
    suspend fun getTodos(): List<TodoEntity> {
        return database.getDao().getAll()
    }

    suspend fun addTodos() {
        mutableListOf(
            TodoEntity(todo = "Cao ja sam todo 1"),
            TodoEntity(todo = "Cao ja sam todo 2"),
            TodoEntity(todo = "Cao ja sam todo 3")
        ).forEach { database.getDao().insert(it) }

    }
}