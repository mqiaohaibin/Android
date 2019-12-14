package cn.paper.android.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import cn.paper.android.R
import cn.paper.library.PPActivity

class ViewPager2Activity : PPActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var pagerAdapter: InternalAdapterr

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager2)

        viewPager = findViewById(R.id.viewPager)
        viewPager.setPageTransformer(DepthPageTransformer())

        pagerAdapter = InternalAdapterr(this)
        pagerAdapter.items = listOf(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.MAGENTA)
        viewPager.adapter = pagerAdapter
    }

    private inner class InternalAdapterr(activity: FragmentActivity) : FragmentStateAdapter(activity) {

        var items: List<Int>? = null

        override fun getItemCount(): Int = items?.size ?: 0

        override fun createFragment(position: Int): Fragment = ColorFragment.newInstance(items?.get(position)
                ?: Color.WHITE, position)

    }
}
