package com.example.taskmaster.presentation.di

import com.example.taskmaster.domain.usecase.DeleteTaskUseCase
import com.example.taskmaster.domain.usecase.EditTaskUseCase
import com.example.taskmaster.domain.usecase.NewTaskUseCase
import com.example.taskmaster.domain.usecase.ViewAllTasksUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<NewTaskUseCase> {
        NewTaskUseCase(repository = get())
    }

    factory<EditTaskUseCase> {
        EditTaskUseCase(repository = get())
    }

    factory<DeleteTaskUseCase> {
        DeleteTaskUseCase(repository = get())
    }

    factory<ViewAllTasksUseCase> {
        ViewAllTasksUseCase(repository = get())
    }
}

