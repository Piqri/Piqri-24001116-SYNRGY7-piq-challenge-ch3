package com.example.synrgy_chapter_3.ui.activities

import LetterAdapter
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.synrgy_chapter_3.R
import com.example.synrgy_chapter_3.model.Letter
import com.example.synrgy_chapter_3.model.Word
import com.example.synrgy_chapter_3.ui.adapters.WordAdapter
import com.example.synrgy_chapter_3.viewmodels.LetterViewModel
import com.example.synrgy_chapter_3.viewmodels.WordViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var letterAdapter: LetterAdapter
    private lateinit var wordAdapter: WordAdapter

    private val letterViewModel: LetterViewModel by viewModels()
    private val wordViewModel: WordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewFirst)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Tampilkan daftar huruf saat aplikasi pertama kali dijalankan
        showLetters()

        letterViewModel.selectedLetter.observe(this) { letter ->
            // Tampilkan daftar kata yang diawali dengan huruf yang diklik
            showWords(letter)
        }

        wordViewModel.selectedWord.observe(this) { word ->
            // Buka browser dengan melakukan pencarian di Google menggunakan kata yang diklik
            openBrowserWithSearch(word)
        }
    }

    private fun showLetters() {
        val letters = ('A'..'Z').map { it.toString() }.map { Letter(it) }

        // Mendapatkan referensi ke RecyclerView dari XML
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewFirst)

        // Membuat adapter dan mengatur adapter ke RecyclerView
        letterAdapter = LetterAdapter(letters) { letter ->
            letterViewModel.selectLetter(letter.value)
        }
        recyclerView.adapter = letterAdapter

        // Mengatur layout manager untuk RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


    private fun showWords(startingLetter: String) {
        // buatkan Tampilkan daftar kata hewan yang diawali dengan huruf yang diklik (contoh: A -> anjing, ayam, angsa)

        val words = when (startingLetter) {
            "A" -> listOf("Apple", "Ant", "Airplane", "Arrow")
            "B" -> listOf("Banana", "Ball", "Book", "Butterfly")
            "C" -> listOf("Car", "Cat", "Cake", "Chair")
            "D" -> listOf("Dog", "Dolphin", "Dragon", "Desk")
            "E" -> listOf("Elephant", "Egg", "Eagle", "Envelope")
            "F" -> listOf("Fish", "Frog", "Fox", "Fan")
            "G" -> listOf("Giraffe", "Goat", "Guitar", "Globe")
            "H" -> listOf("Horse", "House", "Hat", "Hamburger")
            "I" -> listOf("Ice cream", "Island", "Iron", "Ice")
            "J" -> listOf("Jellyfish", "Jacket", "Jar", "Jigsaw")
            "K" -> listOf("Kangaroo", "Kite", "Key", "King")
            "L" -> listOf("Lion", "Lamp", "Leaf", "Lemon")
            "M" -> listOf("Monkey", "Mouse", "Moon", "Milk")
            "N" -> listOf("Nose", "Net", "Nut", "Ninja")
            "O" -> listOf("Owl", "Orange", "Octopus", "Oven")
            "P" -> listOf("Penguin", "Pizza", "Pencil", "Panda")
            "Q" -> listOf("Queen", "Quill", "Quilt", "Quokka")
            "R" -> listOf("Rabbit", "Rainbow", "Rocket", "Robot")
            "S" -> listOf("Snake", "Star", "Sun", "Ship")
            "T" -> listOf("Tiger", "Tree", "Table", "Teapot")
            "U" -> listOf("Umbrella", "Unicorn", "UFO", "Uniform")
            "V" -> listOf("Vase", "Violin", "Volcano", "Vegetable")
            "W" -> listOf("Wolf", "Worm", "Whale", "Watermelon")
            "X" -> listOf("Xylophone", "X-ray", "Xylograph", "Xerus")
            "Y" -> listOf("Yak", "Yo-yo", "Yacht", "Yogurt")
            "Z" -> listOf("Zebra", "Zucchini", "Zipper", "Zoo")
            else -> emptyList()
        }
        wordAdapter = WordAdapter(words.map { Word(it) }) { word ->
            wordViewModel.selectWord(word.value)
        }
        recyclerView.adapter = wordAdapter
    }

    private fun openBrowserWithSearch(query: String) {
        val url = "https://www.google.com/search?q=$query"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
