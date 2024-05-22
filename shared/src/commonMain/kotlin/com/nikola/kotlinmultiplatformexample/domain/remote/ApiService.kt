package com.nikola.kotlinmultiplatformexample.domain.remote

interface ApiService {
    suspend fun getData(): String
}