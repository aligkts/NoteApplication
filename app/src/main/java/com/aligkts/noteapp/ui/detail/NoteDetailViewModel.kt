package com.aligkts.noteapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aligkts.noteapp.data.repository.notes.NoteRepository
import com.aligkts.noteapp.domain.model.Note
import com.aligkts.noteapp.utils.formatToViewDateDefaults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 02,December,2021
 */

@OptIn(FlowPreview::class)
@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val repository: NoteRepository,
) : ViewModel() {

    var note = Note()

    fun insertNote(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }

    fun insertOrUpdateNote() {
        if (note.isEditing()) {
            note.createdDate = Date().formatToViewDateDefaults()
            updateNote(note)
        } else {
            note.createdDate = Date().formatToViewDateDefaults()
            insertNote(note)
        }
    }

}