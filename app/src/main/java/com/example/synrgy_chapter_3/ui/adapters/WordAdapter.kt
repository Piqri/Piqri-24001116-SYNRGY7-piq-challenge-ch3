package com.example.synrgy_chapter_3.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.synrgy_chapter_3.model.Word

class WordAdapter(
    private val words: List<Word>,
    private val onItemClick: (Word) -> Unit
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(words[position])
    }

    override fun getItemCount(): Int = words.size

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewWord: TextView = itemView.findViewById(android.R.id.text1)

        fun bind(word: Word) {
            textViewWord.text = word.value
            itemView.setOnClickListener { onItemClick(word) }
        }
    }
}
