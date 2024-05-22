package com.nikola.kotlinmultiplatformexample.data.di

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.nikola.kotlinmultiplatformexample.data.local.AppDatabase
import com.nikola.kotlinmultiplatformexample.data.local.dbFileName
import com.nikola.kotlinmultiplatformexample.data.local.instantiateImpl
import com.nikola.kotlinmultiplatformexample.domain.remote.ApiService
import platform.Foundation.NSHomeDirectory

actual class Factory {
    actual fun getRoomDatabase(): AppDatabase {
        val dbFilePath = NSHomeDirectory() + dbFileName
        return Room.databaseBuilder<AppDatabase>(
            name = dbFilePath,
            factory = {
                AppDatabase::class.instantiateImpl()
            }
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }

    actual fun getApi(): ApiService = createCommonApi()
}