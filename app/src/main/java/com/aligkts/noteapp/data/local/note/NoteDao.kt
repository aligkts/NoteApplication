package com.aligkts.noteapp.data.local.note

import androidx.room.*
import com.aligkts.noteapp.data.repository.notes.NotesLocalDataSource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ali Göktaş on 01,December,2021
 */
@Dao
interface NoteDao : NotesLocalDataSource {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insert(note: NoteEntity)

    @Query("DELETE FROM notes WHERE id=:noteId")
    override suspend fun delete(noteId: Long)

    @Update
    override suspend fun update(note: NoteEntity)

    @Query("SELECT * FROM notes WHERE id=:noteId")
    override fun getNote(noteId: Long): Flow<NoteEntity?>

    @Query("SELECT * FROM notes")
    override fun getAllNotes(): Flow<List<NoteEntity?>>
}