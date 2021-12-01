package com.aligkts.noteapp.di

import android.content.Context
import androidx.room.Room
import com.aligkts.noteapp.data.local.NoteDatabase
import com.aligkts.noteapp.data.repository.notes.NotesLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Ali Göktaş on 01,December,2021
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java, "notes.db"
        ).build()

    @Provides
    @Singleton
    fun providesNoteDataSource(
        database: NoteDatabase,
    ): NotesLocalDataSource = database.notesDao()
}