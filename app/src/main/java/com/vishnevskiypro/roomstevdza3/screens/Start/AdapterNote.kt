package com.vishnevskiypro.roomstevdza3.screens.Start

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.roomstevdza3.databinding.NoteItemBinding
import com.vishnevskiypro.roomstevdza3.model.Note

class AdapterNote : RecyclerView.Adapter<AdapterNote.NoteViewHolder>() {

    inner class NoteViewHolder(val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root)

    var listOfNotes = emptyList<Note>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(NoteItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = listOfNotes[position]

        holder.binding .apply {
            textViewId.text = item.id.toString()
            textViewTitle.text = item.title
        }

        //On click
        holder.binding.itemLayout.setOnClickListener {
            val action = StartFragmentDirections.actionStartFragmentToUpdateFragment(item)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = listOfNotes.size

    fun setAdapter(list: List<Note>){
        listOfNotes = list
        notifyDataSetChanged()
    }
}