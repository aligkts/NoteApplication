package com.aligkts.noteapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aligkts.noteapp.data.local.note.NoteDao
import com.aligkts.noteapp.data.local.note.NoteEntity

/**
 * Created by Ali Göktaş on 01,December,2021
 */
@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun notesDao(): NoteDao
}