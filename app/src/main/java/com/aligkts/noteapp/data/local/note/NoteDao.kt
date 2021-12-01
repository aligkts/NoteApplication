package com.aligkts.noteapp.data.local.note

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aligkts.noteapp.data.repository.notes.NotesLocalDataSource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ali Göktaş on 01,December,2021
 */
@Dao
interface NoteDao : NotesLocalDataSource {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insert(notes: NoteEntity)

    @Query("SELECT * FROM notes WHERE id=:id")
    override fun getNoteFlow(id: Long): Flow<NoteEntity?>
}