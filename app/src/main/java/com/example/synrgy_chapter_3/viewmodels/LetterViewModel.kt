package com.example.synrgy_chapter_3.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LetterViewModel : ViewModel() {

    private val _selectedLetter = MutableLiveData<String>()
    val selectedLetter: LiveData<String>
        get() = _selectedLetter

    fun selectLetter(letter: String) {
        _selectedLetter.value = letter
    }
}