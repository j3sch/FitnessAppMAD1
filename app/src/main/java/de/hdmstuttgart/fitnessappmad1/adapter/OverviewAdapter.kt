package de.hdmstuttgart.fitnessappmad1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.hdmstuttgart.fitnessappmad1.databinding.ItemOverviewBinding

class OverviewAdapter(
    private var overview: List<Overview>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<OverviewAdapter.OverviewViewHolder>() {

    private lateinit var binding: ItemOverviewBinding

    inner class OverviewViewHolder(binding: ItemOverviewBinding) : RecyclerView.ViewHolder(binding.root),
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        binding = ItemOverviewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return  OverviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        holder.itemView.apply {
            binding.tvOverviewTitle.text = overview[position].title
            binding.tvOverviewDisciplines.text = overview[position].disciplines
            binding.tvOverviewTime.text = overview[position].time
        }
    }
    
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun getItemCount(): Int {
        return overview.size
    }
}