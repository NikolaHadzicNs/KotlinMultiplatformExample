package com.nikola.kotlinmultiplatformexample.android.di

import android.app.Application
import com.nikola.kotlinmultiplatformexample.data.di.AppContainer
import com.nikola.kotlinmultiplatformexample.data.di.Factory

class App: Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(Factory(this))
    }
}