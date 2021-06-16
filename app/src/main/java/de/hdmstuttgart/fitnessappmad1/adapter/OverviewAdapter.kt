package de.hdmstuttgart.fitnessappmad1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.hdmstuttgart.fitnessappmad1.R
import kotlinx.android.synthetic.main.item_overview.view.*

class OverviewAdapter(
    var overview: List<Overview>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<OverviewAdapter.OverviewViewHolder>() {

    inner class OverviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_overview, parent, false)
        return  OverviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        holder.itemView.apply {
            tvOverviewTitle.text = overview[position].title
            tvOverviewDisciplines.text = overview[position].disciplines
            tvOverviewTime.text = overview[position].time
        }
    }
    
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun getItemCount(): Int {
        return overview.size
    }
}