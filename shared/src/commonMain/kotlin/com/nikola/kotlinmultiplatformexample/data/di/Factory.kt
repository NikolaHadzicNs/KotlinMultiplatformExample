package com.nikola.kotlinmultiplatformexample.data.di

import com.nikola.kotlinmultiplatformexample.data.local.AppDatabase

expect class Factory {
    fun getRoomDatabase(): AppDatabase
}