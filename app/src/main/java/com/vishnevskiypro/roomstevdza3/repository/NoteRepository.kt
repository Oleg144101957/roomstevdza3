package com.vishnevskiypro.roomstevdza3.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vishnevskiypro.roomstevdza3.data.NoteDao
import com.vishnevskiypro.roomstevdza3.model.Note

class NoteRepository(val noteDao: NoteDao) {

    val readAllNotes: LiveData<List<Note>> = noteDao.readAllNotes()

    fun addNote(note: Note){
        noteDao.addNote(note)
    }

    fun updateNote(note: Note){
        noteDao.updateNote(note)
    }

}