package com.aligkts.noteapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aligkts.noteapp.data.repository.notes.NoteRepository
import com.aligkts.noteapp.domain.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 01,December,2021
 */
@OptIn(FlowPreview::class)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: NoteRepository,
) : ViewModel() {

    val notes = repository.getAllNotes()

    fun deleteNote(noteId: Long) = viewModelScope.launch {
        repository.deleteNote(noteId)
    }

}