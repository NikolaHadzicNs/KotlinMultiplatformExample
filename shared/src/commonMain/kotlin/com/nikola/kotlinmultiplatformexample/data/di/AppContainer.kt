package com.nikola.kotlinmultiplatformexample.data.di

import com.nikola.kotlinmultiplatformexample.data.AppRepository

class AppContainer(
    private val factory: Factory
) {
    val appRepository: AppRepository by lazy {
        AppRepository(
            database = factory.getRoomDatabase()
        )
    }
}