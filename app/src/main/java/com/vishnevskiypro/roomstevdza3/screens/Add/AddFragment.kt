package com.vishnevskiypro.roomstevdza3.screens.Add

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
import com.vishnevskiypro.roomstevdza3.R
import com.vishnevskiypro.roomstevdza3.databinding.FragmentAddBinding
import com.vishnevskiypro.roomstevdza3.databinding.NoteItemBinding
import com.vishnevskiypro.roomstevdza3.model.Note
import com.vishnevskiypro.roomstevdza3.viewmodel.NoteViewModel


class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        binding.save.setOnClickListener {
            addNoteToDatabase()
        }


        return binding.root
    }

    fun addNoteToDatabase(){
        val title = binding.noteTitle.text.toString()
        val description = binding.description.text.toString()

        if (checkData(title, description)){
            val noteToAdd = Note(id = 0, title = title, description = description)
            mViewModel.addNote(noteToAdd)
            Toast.makeText(context, "Note added", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_startFragment)
        } else {
            Toast.makeText(context, "Fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    fun checkData(title: String, description: String) : Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description))
    }

}