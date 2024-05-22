package com.nikola.kotlinmultiplatformexample.data.remote

import com.nikola.kotlinmultiplatformexample.domain.remote.ApiService
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class ApiServiceImpl(private val client: HttpClient) : ApiService {

    override suspend fun getData(): String {
        val response = client.get("https://ktor.io/docs/")
        return response.bodyAsText()
    }
}