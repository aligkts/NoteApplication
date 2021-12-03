package com.aligkts.noteapp.domain.model

import android.os.Parcelable
import com.aligkts.noteapp.data.local.note.NoteEntity
import com.aligkts.noteapp.ui.common.base.ListAdapterItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    override val id: Long,
    var title: String,
    var detail: String,
    var createdDate: String?,
    var imageUrl: String?,
    var edited: Boolean = false
) : Parcelable, ListAdapterItem {

    fun toEntity() = NoteEntity(id, title, detail, createdDate, imageUrl, edited)

}