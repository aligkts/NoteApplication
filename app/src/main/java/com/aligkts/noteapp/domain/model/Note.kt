package com.aligkts.noteapp.domain.model

import android.os.Parcelable
import com.aligkts.noteapp.data.local.note.NoteEntity
import com.aligkts.noteapp.ui.common.base.ListAdapterItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    override val id: Long,
    val title: String,
    val overview: String,
    val editDate: String?,
    val imageUrl: String?
) : Parcelable, ListAdapterItem {

    fun toEntity() = NoteEntity(id, title, overview, editDate, imageUrl)
}