package com.vishnevskiypro.roomstevdza3.screens.Start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.roomstevdza3.R
import com.vishnevskiypro.roomstevdza3.databinding.FragmentStartBinding
import com.vishnevskiypro.roomstevdza3.viewmodel.NoteViewModel

class StartFragment : Fragment() {

    private lateinit var mViewModel: NoteViewModel
    private lateinit var binding: FragmentStartBinding
    private lateinit var adapter: AdapterNote
    private lateinit var recycler: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentStartBinding.inflate(layoutInflater, container, false)

        mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        adapter = AdapterNote()
        recycler = binding.recyclerView
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())

        mViewModel.readAllData.observe(viewLifecycleOwner, Observer { list ->
            adapter.setAdapter(list)
        })

        binding.addNote.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_addFragment)
        }

        return binding.root
    }

}