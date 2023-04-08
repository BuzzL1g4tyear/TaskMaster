package com.example.taskmaster.presentation.di

import com.example.taskmaster.presentation.screens.add.AddViewModel
import com.example.taskmaster.presentation.screens.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        MainViewModel(viewAllTasksUseCase = get())
    }
    viewModel {
        AddViewModel(newTaskUseCase = get())
    }

}