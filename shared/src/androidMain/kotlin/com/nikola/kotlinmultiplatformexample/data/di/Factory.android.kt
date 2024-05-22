package com.nikola.kotlinmultiplatformexample.data.di

import android.app.Application
import androidx.room.Room
import com.nikola.kotlinmultiplatformexample.data.local.AppDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.nikola.kotlinmultiplatformexample.data.local.dbFileName
import kotlinx.coroutines.Dispatchers


actual class Factory(private val app: Application) {
    actual fun getRoomDatabase(): AppDatabase {
        val dbFile = app.getDatabasePath(dbFileName)
        return Room.databaseBuilder<AppDatabase>(app, dbFile.absolutePath)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}