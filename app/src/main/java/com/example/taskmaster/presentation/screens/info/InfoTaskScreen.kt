package com.example.taskmaster.presentation.screens.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmaster.domain.model.Task

@Composable
fun InfoScreen(task: Task) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = task.title, fontSize = 36.sp, modifier = Modifier.padding(all = 24.dp)
        )
    }
}