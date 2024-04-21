package com.example.synrgy_chapter_3.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordViewModel : ViewModel() {

    private val _selectedWord = MutableLiveData<String>()
    val selectedWord: LiveData<String>
        get() = _selectedWord

    fun selectWord(word: String) {
        _selectedWord.value = word
    }
}