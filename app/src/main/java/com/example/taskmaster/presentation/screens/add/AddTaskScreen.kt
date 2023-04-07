package com.example.taskmaster.presentation.screens.add

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddScreen() {

    Scaffold(floatingActionButton = {

    }) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Add", fontSize = 36.sp, modifier = Modifier.padding(all = 24.dp)
            )

        }
    }
}