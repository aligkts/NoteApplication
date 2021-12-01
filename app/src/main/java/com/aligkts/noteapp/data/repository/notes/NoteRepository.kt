package com.aligkts.noteapp.data.repository.notes

import com.aligkts.noteapp.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 01,December,2021
 */
class NoteRepository @Inject constructor(private val local: NotesLocalDataSource) {

    fun getNote(id: Long): Flow<Note?> =
        local.getNoteFlow(id).transform { localNote ->
            emit(localNote?.toNote())
        }
}