package com.nikola.kotlinmultiplatformexample.data

import com.nikola.kotlinmultiplatformexample.data.local.AppDatabase
import com.nikola.kotlinmultiplatformexample.data.local.entity.TodoEntity
import com.nikola.kotlinmultiplatformexample.domain.remote.ApiService

class AppRepository(
    private val database: AppDatabase,
    private val api: ApiService
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

    suspend fun getDataFromApi(): String {
        return api.getData()
    }
}