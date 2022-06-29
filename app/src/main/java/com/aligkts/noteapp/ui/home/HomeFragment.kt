package com.aligkts.noteapp.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.aligkts.noteapp.R
import com.aligkts.noteapp.databinding.FragmentHomeBinding
import com.aligkts.noteapp.domain.model.Note
import com.aligkts.noteapp.ui.common.base.BaseFragment
import com.aligkts.noteapp.ui.common.base.ItemSwipeHandler
import com.aligkts.noteapp.utils.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by Ali Göktaş on 01,December,2021
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModels()
    private val noteAdapter by lazy { NoteAdapter(::onNoteClicked) }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBindings()
        observeNotes()
        setHasOptionsMenu(true)
    }

    private fun setupBindings() = with(binding) {
        viewModel = homeViewModel
        rvNotes.apply {
            adapter = noteAdapter
            addItemDecoration(
                DefaultItemDecorator(
                    resources.getDimensionPixelSize(R.dimen.spacing_small),
                    resources.getDimensionPixelSize(R.dimen.spacing_small)
                )
            )
        }
        ItemTouchHelper(
            ItemSwipeHandler(requireContext(), noteAdapter) {
                homeViewModel.deleteNote(it.id)
            }
        ).apply { attachToRecyclerView(rvNotes) }
    }

    private fun observeNotes() = viewLifecycleOwner.lifecycleScope.launch {
        homeViewModel.notes.collectLatest {
            noteAdapter.submitList(it)
            if (it.isNullOrEmpty()) {
                binding.txtEmptyNote.show()
                binding.rvNotes.gone()
            } else {
                binding.txtEmptyNote.gone()
                binding.rvNotes.show()
            }
        }
    }

    private fun onNoteClicked(clickedNote: Note) {
        findNavController().navigateSafe(
            HomeFragmentDirections.actionNavigationHomeToNavigationNoteDetail(
                note = clickedNote
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add_note -> {
                findNavController().navigateSafe(HomeFragmentDirections.actionNavigationHomeToNavigationNoteDetail())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}