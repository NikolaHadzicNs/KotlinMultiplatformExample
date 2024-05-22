package com.nikola.kotlinmultiplatformexample.android

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.nikola.kotlinmultiplatformexample.android.di.App
import com.nikola.kotlinmultiplatformexample.data.AppRepository
import com.nikola.kotlinmultiplatformexample.data.local.entity.TodoEntity
import kotlinx.coroutines.launch

class MainViewModel(private val repository: AppRepository): ViewModel() {

    var listTodos = mutableStateListOf<TodoEntity>()


    init {
        viewModelScope.launch {
            repository.addTodos()
            val todos = repository.getTodos()
            listTodos.clear()
            listTodos.addAll(todos)
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as App)
                val repository = application.appContainer.appRepository
                MainViewModel(repository = repository)
            }
        }
    }
}