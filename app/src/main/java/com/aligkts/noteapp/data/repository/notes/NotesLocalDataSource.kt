package com.aligkts.noteapp.data.repository.notes

import com.aligkts.noteapp.data.local.note.NoteEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ali Göktaş on 01,December,2021
 */
interface NotesLocalDataSource {
    suspend fun insert(note: NoteEntity)
    suspend fun delete(noteId: Long)
    suspend fun update(note: NoteEntity)
    fun getNote(noteId: Long): Flow<NoteEntity?>
    fun getAllNotes(): Flow<List<NoteEntity?>>
}
