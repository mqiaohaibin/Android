package cn.paper.library.widget

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PPLoopAdapter<VH : RecyclerView.ViewHolder>(val adapter: RecyclerView.Adapter<VH>) : RecyclerView.Adapter<VH>() {

    override fun getItemViewType(position: Int): Int {
        val innerAdapterPosition = getInnerAdapterPosition(position)
        return adapter.getItemViewType(innerAdapterPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return adapter.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        if (adapter.itemCount == 0) {
            return 0
        } else {
            return adapter.itemCount + 2
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val innerAdapterPosition = getInnerAdapterPosition(position)
        adapter.onBindViewHolder(holder, innerAdapterPosition)
    }

    private fun getInnerAdapterPosition(position: Int): Int {
        return when (position) {
            0 -> itemCount - 3
            itemCount - 1 -> 0
            else -> position - 1
        }
    }

}