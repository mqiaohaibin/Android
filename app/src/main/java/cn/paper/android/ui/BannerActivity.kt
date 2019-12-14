package cn.paper.android.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import cn.paper.android.R
import cn.paper.library.PPActivity
import cn.paper.library.widget.PPLoopViewPager

class BannerActivity : PPActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerLooper: PPLoopViewPager
    private lateinit var adapter: InternalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager2)

        viewPager = findViewById(R.id.viewPager)
        viewPager.setPageTransformer(ZoomOutPageTransformer())

        adapter = InternalAdapter()
        adapter.items = listOf(Color.BLUE, Color.DKGRAY, Color.RED, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.BLACK)

        viewPagerLooper = PPLoopViewPager(viewPager)
        viewPagerLooper.setAdapter(adapter)
    }

    private inner class InternalViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        var textView: TextView = itemview.findViewById(R.id.textView)

    }

    private inner class InternalAdapter(var items: List<Int>? = null) : RecyclerView.Adapter<InternalViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InternalViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
            return InternalViewHolder(itemView)
        }

        override fun getItemCount(): Int = items?.size ?: 0

        override fun onBindViewHolder(holder: InternalViewHolder, position: Int) {
            items?.let {
                holder.itemView.setBackgroundColor(it.get(position))
                holder.textView.setText(Integer.toString(position))
            }
        }

    }
}
