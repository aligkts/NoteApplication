package com.aligkts.noteapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aligkts.noteapp.data.repository.notes.NoteRepository
import com.aligkts.noteapp.domain.model.Note
import com.aligkts.noteapp.utils.formattedDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

/**
 * Created by Ali Göktaş on 02,December,2021
 */

@OptIn(FlowPreview::class)
@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val repository: NoteRepository,
) : ViewModel() {

    var note: Note? = null
    var title: String = ""
    var detail: String = ""
    var imageUrl: String? = null

    fun setCurrentNote(currentNote: Note) {
        note = currentNote
        title = currentNote.title
        detail = currentNote.detail
        imageUrl = currentNote.imageUrl
    }

    private fun insertNote(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

    private fun updateNote(note: Note) = viewModelScope.launch {
        note.edited = true
        repository.updateNote(note)
    }

    fun insertOrUpdateNote() {
        note?.let { note ->
            updateNote(note)
        } ?: run {
            val note = Note(
                id = Random.nextLong(),
                title = title,
                detail = detail,
                createdDate = Date().formattedDate(),
                imageUrl = imageUrl
            )
            insertNote(note)
        }
    }

    fun allInputsCompleted() = title.isNotEmpty() && detail.isNotEmpty()

}