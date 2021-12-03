package com.aligkts.noteapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.aligkts.noteapp.R
import com.aligkts.noteapp.databinding.FragmentNoteDetailBinding
import com.aligkts.noteapp.ui.common.base.BaseFragment
import com.aligkts.noteapp.utils.hideKeyboard
import com.aligkts.noteapp.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ali Göktaş on 02,December,2021
 */

@AndroidEntryPoint
class NoteDetailFragment : BaseFragment<FragmentNoteDetailBinding>() {

    private val noteDetailViewModel: NoteDetailViewModel by viewModels()
    private val args: NoteDetailFragmentArgs by navArgs()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ) = FragmentNoteDetailBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readArgs()
        initUI()
    }

    private fun readArgs() {
        args.note?.let {
            noteDetailViewModel.setCurrentNote(it)
        }
    }

    private fun initUI() = with(binding) {
        viewModel = noteDetailViewModel
        btnAddOrEdit.setOnClickListener {
            if (noteDetailViewModel.allInputsCompleted()) {
                noteDetailViewModel.insertOrUpdateNote()
                findNavController().popBackStack()
            } else {
                showToast(getString(R.string.fill_inputs_error))
            }
        }
    }

    override fun onStop() {
        super.onStop()
        requireContext().hideKeyboard(requireView())
    }
}