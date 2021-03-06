package com.aligkts.noteapp.data.local.note

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aligkts.noteapp.domain.model.Note
import com.google.gson.annotations.SerializedName

/**
 * Created by Ali Göktaş on 01,December,2021
 */
@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey
    @field:SerializedName("id") val id: Long,
    @field:SerializedName("title") val title: String,
    @field:SerializedName("detail") val detail: String,
    @field:SerializedName("created_date") val createdDate: String?,
    @field:SerializedName("image_url") val imageUrl: String?,
    @field:SerializedName("edited") val edited: Boolean,
) {

    fun toNote() = Note(
        id = id,
        title = title,
        detail = detail,
        createdDate = createdDate,
        imageUrl = imageUrl,
        edited = edited
    )
}