package com.example.taskmaster.presentation.screens.edit

import androidx.lifecycle.ViewModel
import com.example.taskmaster.domain.usecase.DeleteTaskUseCase
import com.example.taskmaster.domain.usecase.EditTaskUseCase

class EditViewModel(
    private val editTaskUseCase: EditTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {

}