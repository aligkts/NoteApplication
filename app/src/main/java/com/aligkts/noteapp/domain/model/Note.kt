package com.aligkts.noteapp.domain.model

import android.os.Parcelable
import com.aligkts.noteapp.data.local.note.NoteEntity
import com.aligkts.noteapp.ui.common.base.ListAdapterItem
import com.aligkts.noteapp.utils.formatToViewDateDefaults
import kotlinx.parcelize.Parcelize
import java.util.*
import kotlin.random.Random

@Parcelize
data class Note(
    override val id: Long,
    var title: String,
    var detail: String,
    var createdDate: String?,
    var editedDate: String?,
    var imageUrl: String?
) : Parcelable, ListAdapterItem {

    constructor() : this(
        Random.nextLong(),
        title = "",
        detail = "",
        createdDate = null,
        editedDate = null,
        imageUrl = null
    )

    fun toEntity() = NoteEntity(id, title, detail, createdDate, editedDate,
        imageUrl)

    fun isEditing() = createdDate.isNullOrEmpty().not()
}