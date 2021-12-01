package com.aligkts.noteapp.di

import android.content.Context
import androidx.room.Room
import com.aligkts.noteapp.data.local.NoteDatabase
import com.aligkts.noteapp.data.repository.notes.NotesLocalDataSource
import com.bumptech.glide.util.Executors
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
object TestDatabaseModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(
        @ApplicationContext context: Context,
    ): NoteDatabase =
        Room.inMemoryDatabaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
        )
            .allowMainThreadQueries()
            .setTransactionExecutor(Executors.mainThreadExecutor())
            .setQueryExecutor(Executors.mainThreadExecutor())
            .build()

    @Provides
    @Singleton
    fun providesNoteDataSource(
        database: NoteDatabase,
    ): NotesLocalDataSource = database.notesDao()

    @Provides
    @Singleton
    fun providesNoteDao(database: NoteDatabase) = database.notesDao()

}