package com.aligkts.noteapp.ui.home

import androidx.lifecycle.ViewModel
import com.aligkts.noteapp.data.repository.notes.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 01,December,2021
 */
@OptIn(FlowPreview::class)
@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: NoteRepository,
) : ViewModel() {

}