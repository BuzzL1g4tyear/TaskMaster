package com.example.taskmaster.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task(
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Int
) : Parcelable
