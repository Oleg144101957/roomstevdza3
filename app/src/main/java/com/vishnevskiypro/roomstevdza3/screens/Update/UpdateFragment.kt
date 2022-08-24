package com.vishnevskiypro.roomstevdza3.screens.Update

import android.icu.text.CaseMap
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vishnevskiypro.roomstevdza3.R
import com.vishnevskiypro.roomstevdza3.databinding.FragmentUpdateBinding
import com.vishnevskiypro.roomstevdza3.model.Note
import com.vishnevskiypro.roomstevdza3.viewmodel.NoteViewModel

class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding = FragmentUpdateBinding.inflate(layoutInflater, container, false)

        binding.noteTitle.setText(args.noteArgument.title)
        binding.description.setText(args.noteArgument.description)

        binding.save.setOnClickListener {
            updateNote()
        }

        return binding.root
    }

    private fun updateNote() {
        val title = binding.noteTitle.text.toString()
        val description = binding.description.text.toString()

        if (checkData(title = title, description = description)){

            val noteToUpdate = Note(id = args.noteArgument.id, title = title, description = description)

            mViewModel.updateNote(noteToUpdate)

            Toast.makeText(requireContext(), "Updated", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_startFragment)
        } else {
            Toast.makeText(requireContext(), "Fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkData(title: String, description: String) : Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description))
    }

}