import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.synrgy_chapter_3.model.Letter

class LetterAdapter(
    private val letters: List<Letter>,
    private val onItemClick: (Letter) -> Unit
) : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return LetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        holder.bind(letters[position])
    }

    override fun getItemCount(): Int = letters.size

    inner class LetterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewLetter: TextView = itemView.findViewById(android.R.id.text1)

        fun bind(letter: Letter) {
            textViewLetter.text = letter.value
            itemView.setOnClickListener { onItemClick(letter) }
        }
    }
}
