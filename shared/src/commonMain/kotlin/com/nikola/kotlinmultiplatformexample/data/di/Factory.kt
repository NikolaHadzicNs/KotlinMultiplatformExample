package com.nikola.kotlinmultiplatformexample.data.di

import com.nikola.kotlinmultiplatformexample.data.local.AppDatabase
import com.nikola.kotlinmultiplatformexample.data.remote.ApiServiceImpl
import com.nikola.kotlinmultiplatformexample.domain.remote.ApiService
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

expect class Factory {
    fun getRoomDatabase(): AppDatabase
    fun getApi(): ApiService
}

internal fun createCommonApi(): ApiService = ApiServiceImpl(
    client = HttpClient {
        install(ContentNegotiation) {
            json(json, contentType = ContentType.Any)
        }
    }
)

val json = Json { ignoreUnknownKeys = true }