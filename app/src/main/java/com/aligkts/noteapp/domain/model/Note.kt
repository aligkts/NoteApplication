package com.aligkts.noteapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val id: Long,
    val title: String,
    val overview: String,
    val editDate: String?,
    val imageUrl: String?
) : Parcelable