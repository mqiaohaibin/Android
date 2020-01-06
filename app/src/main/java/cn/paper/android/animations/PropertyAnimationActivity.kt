package cn.paper.android.animations

import android.animation.*
import android.graphics.Color
import android.graphics.Path
import android.os.Build
import android.os.Bundle
import android.view.View
import cn.paper.android.R
import cn.paper.library.PPActivity
import kotlinx.android.synthetic.main.activity_property_animation.*

class PropertyAnimationActivity : PPActivity() {

    private var isRed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_animation)

        btnChangeColor.setOnClickListener {
            if (isRed) {
                animateUsingObjectAnimator(Color.RED, Color.WHITE)
                isRed = false
            } else {
                animateUsingObjectAnimator(Color.WHITE, Color.RED)
                isRed = true
            }
        }
    }

    private fun animateUsingValueAnimator(from: Int, to: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ValueAnimator.ofArgb(from, to).apply {
                addUpdateListener {
                    textView.setBackgroundColor(animatedValue as Int)
                }
                start()
            }
        } else {
            ValueAnimator.ofInt(from, to).apply {
                addUpdateListener {
                    textView.setBackgroundColor(animatedValue as Int)
                }
                start()
            }
        }
    }

    private fun animateUsingObjectAnimator(from: Int, to: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ObjectAnimator.ofArgb(textView, "backgroundColor", from, to).apply {
                start()
            }
        } else {
            ObjectAnimator.ofInt(textView, "backgroundColor", from, to).apply {
                start()
            }
        }
    }

    private fun pathAnimator() {
        val path = Path().apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                arcTo(0f, 0f, 1000f,  1000f, 270f, -180f, true)
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ObjectAnimator.ofFloat(textView, View.X, View.Y, path).apply {
                start()
            }
        }
    }

}