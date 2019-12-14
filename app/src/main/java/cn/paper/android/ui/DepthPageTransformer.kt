package cn.paper.android.ui

import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class DepthPageTransformer(val minScale: Float = 0.75f) : ViewPager.PageTransformer, ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        page.apply {
            val pageWidth = width
            when {
                position < -1 -> {
                    alpha = 0f
                }
                position <= 0 -> {
                    alpha = 1f
                    translationX = 0f
                    scaleX = 1f
                    scaleY = 1f
                }
                position <= 1 -> {
                    alpha = 1 - position
                    translationX = pageWidth * -position

                    val scale = minScale + (1 - minScale) * (1 - position)
                    scaleX = scale
                    scaleY = scale
                }
                else -> {
                    alpha = 0f
                }
            }
        }
    }
}