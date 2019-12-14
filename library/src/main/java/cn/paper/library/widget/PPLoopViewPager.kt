package cn.paper.library.widget

import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class PPLoopViewPager(val viewPager: ViewPager2, var autoScroll: Boolean = true) {

    private val handler = Handler(Looper.getMainLooper())
    private val scrollRunnable = {
        viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        if (autoScroll) {
            startScroll()
        }
    }

    init {
        viewPager.registerOnPageChangeCallback(InternalOnPageChangeCallback())
    }

    fun <VH : RecyclerView.ViewHolder> setAdapter(adapter: RecyclerView.Adapter<VH>?) {
        var loopAdapter = adapter?.let { PPLoopAdapter(adapter) } ?: null
        viewPager.adapter = loopAdapter

        setCurrentItem(6, false)

        if (autoScroll) {
            startScroll()
        }
    }

    fun startScroll() {
        handler.postDelayed(scrollRunnable, 2000)
    }

    fun stopScroll() {
        handler.removeCallbacks(scrollRunnable)
    }

    fun setCurrentItem(item: Int, smoothScroll: Boolean = true) {
        viewPager.adapter?.let {
            if (item >= 0 && item < (it as PPLoopAdapter).adapter.itemCount) {
                viewPager.setCurrentItem(item + 1, smoothScroll)
            }
        }
    }

    fun getCurrentItem(): Int {
        return viewPager.currentItem - 1;
    }

    private inner class InternalOnPageChangeCallback : ViewPager2.OnPageChangeCallback() {

        private var lastState: Int = ViewPager2.SCROLL_STATE_IDLE
        override fun onPageScrollStateChanged(state: Int) {
            if (state == ViewPager2.SCROLL_STATE_IDLE || lastState != ViewPager2.SCROLL_STATE_IDLE) {
                viewPager.adapter?.let {
                    val position = viewPager.currentItem;
                    if (position == 0) {
                        setCurrentItem((it as PPLoopAdapter).adapter.itemCount - 1, false)
                    } else if (position == (it.itemCount - 1)) {
                        setCurrentItem(0, false)
                    }
                }
            }
            lastState = state
        }
    }

}