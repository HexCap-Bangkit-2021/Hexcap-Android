package com.rivaldofez.mynotesapps.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.rivaldofez.mynotesapps.database.Note
import com.rivaldofez.mynotesapps.repository.NoteRepository

class MainViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(sort: String): LiveData<PagedList<Note>> {
        return LivePagedListBuilder(mNoteRepository.getAllNotes(sort), 20).build()
    }
}