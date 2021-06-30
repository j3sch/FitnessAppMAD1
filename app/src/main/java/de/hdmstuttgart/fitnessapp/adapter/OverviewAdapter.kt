package de.hdmstuttgart.fitnessapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.databinding.ItemOverviewBinding

class OverviewAdapter(
    private var overview: ArrayList<Exercise>,
    private val listener: OnItemClickListener,
    private val disciplineList: List<Discipline>
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
            binding.tvOverviewTitle.text = overview[position].name
            binding.tvOverviewDisciplines.text = disciplineList[overview[position].disciplineId - 1].name
            binding.tvOverviewTime.text = resources.getString(R.string.overviewDuration, overview[position].duration.toString())
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun getItemCount(): Int {
        return overview.size
    }
}