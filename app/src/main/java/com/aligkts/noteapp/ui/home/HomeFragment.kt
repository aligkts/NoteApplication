package com.aligkts.noteapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.aligkts.noteapp.databinding.FragmentHomeBinding
import com.aligkts.noteapp.ui.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by Ali Göktaş on 01,December,2021
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var noteAdapter: NoteAdapter

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariables()
        setupBindings()
        observeNotes()
    }

    private fun initVariables() {
        noteAdapter = NoteAdapter(::onNoteClicked)
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun setupBindings() = with(binding) {
        rvNotes.adapter = noteAdapter
    }

    private fun observeNotes() = viewLifecycleOwner.lifecycleScope.launch {
        homeViewModel.notes.collectLatest {
            noteAdapter.submitList(it)
        }
    }

    private fun onNoteClicked() {

    }
}