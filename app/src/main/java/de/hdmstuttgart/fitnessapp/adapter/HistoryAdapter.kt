package de.hdmstuttgart.fitnessapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.hdmstuttgart.fitnessapp.databinding.ItemHistoryBinding
import de.hdmstuttgart.fitnessapp.fragments.HistoryFragment

class HistoryAdapter(
    private var histories: List<History>,
    private val listener: HistoryFragment,
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private lateinit var binding: ItemHistoryBinding

    inner class HistoryViewHolder(binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root),
    View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        binding = ItemHistoryBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return  HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.itemView.apply {
            binding.tvHistoryTitle.text = histories[position].title
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun getItemCount(): Int {
        return histories.size
    }
}