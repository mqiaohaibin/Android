package cn.paper.android.ui

import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class ZoomOutPageTransformer(val minScale: Float = 0.85f, val minAlpha: Float = 0.5f) : ViewPager.PageTransformer, ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        page.apply {
            val pageWidth = width
            val pageHeight = height
            when {
                position < -1 -> {
                    alpha = 0f
                }
                position <= 1 -> {
                    val scale = Math.max(minScale, 1 - Math.abs(position))

                    scaleX = scale
                    scaleY = scale

                    alpha = (minAlpha + (((scale - minAlpha) / (1 - minAlpha)) * (1 - minAlpha)))
                }
                else -> {
                    alpha = 0f
                }
            }
        }
    }
}