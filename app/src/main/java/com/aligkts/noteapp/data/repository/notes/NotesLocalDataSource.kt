package com.aligkts.noteapp.data.repository.notes

import com.aligkts.noteapp.data.local.note.NoteEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ali Göktaş on 01,December,2021
 */
interface NotesLocalDataSource {
    fun getNoteFlow(id: Long): Flow<NoteEntity?>
    suspend fun insert(notes: NoteEntity)
}
