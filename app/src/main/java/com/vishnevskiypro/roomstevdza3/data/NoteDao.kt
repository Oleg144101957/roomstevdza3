package com.vishnevskiypro.roomstevdza3.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vishnevskiypro.roomstevdza3.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun readAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)

}