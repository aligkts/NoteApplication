package com.aligkts.noteapp.ui.home

import com.aligkts.noteapp.R
import com.aligkts.noteapp.databinding.ListItemNoteBinding
import com.aligkts.noteapp.domain.model.Note
import com.aligkts.noteapp.ui.common.base.BaseListAdapter

/**
 * Created by Ali Göktaş on 01,December,2021
 */

class NoteAdapter(private val onItemClick: () -> Unit): BaseListAdapter<ListItemNoteBinding, Note>() {

    override fun getLayoutId(position: Int): Int = R.layout.list_item_note

    override fun bind(binding: ListItemNoteBinding,
                      item: Note,
                      position: Int) {
        binding.apply {
            model = item
        }
    }
}