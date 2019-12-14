package cn.paper.android.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import cn.paper.android.R
import cn.paper.library.PPActivity

class ViewPagerActivity : PPActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: InternalPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        viewPager = findViewById(R.id.viewPager)
        viewPager.setPageTransformer(true, ZoomOutPageTransformer())
        pagerAdapter = InternalPagerAdapter(supportFragmentManager)
        pagerAdapter.items = listOf(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.MAGENTA)
        viewPager.adapter = pagerAdapter
    }

    private inner class InternalPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        var items: List<Int>? = null

        override fun getItem(position: Int): Fragment = ColorFragment.newInstance(items?.get(position)
                ?: Color.WHITE, position)

        override fun getCount() = items?.size ?: 0

    }
}
