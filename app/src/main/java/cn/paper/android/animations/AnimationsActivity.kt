package cn.paper.android.animations

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import cn.paper.android.R
import cn.paper.library.PPActivity
import kotlinx.android.synthetic.main.activity_animations.*

class AnimationsActivity : PPActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animations)

        btnAutoLayout.setOnClickListener(this)
        btnPropertyAnimation.setOnClickListener(this)
        btnActivityTransition.setOnClickListener(this)
        btnActivityTransition21.setOnClickListener(this)
        ap_activity_transitionSharedElements.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            var intent = Intent()
            if (it.id == R.id.btnAutoLayout) {
                intent.setClass(this, AutoLayoutActivity::class.java)
            } else if (it.id == R.id.btnPropertyAnimation) {
                intent.setClass(this, PropertyAnimationActivity::class.java)
            } else if (it.id == R.id.btnActivityTransition) {
                intent.setClass(this, TransitionActivity::class.java)
                intent.putExtra(TransitionActivity.EXTRA_FROM, TransitionActivity.EXTRA_FROM_VALUE_DEFAULT)
            } else if (it.id == R.id.btnActivityTransition21) {
                startActivityByBaseTransitions()
            } else if (it.id == R.id.ap_activity_transitionSharedElements) {
                startActivityWithSharedElements()
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }

            if (it.id == R.id.btnActivityTransition) {
                overridePendingTransition(R.anim.open_enter_animation, R.anim.keep_animation)
            }
        }
    }

    private fun startActivityByTransitionCustomAnimation() {
        var options = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.open_enter_animation, R.anim.open_exit_animation)
        var intent = Intent(this, TransitionActivity::class.java)
        ActivityCompat.startActivity(this, intent, options.toBundle())
    }

    private fun startActivityByBaseTransitions() {
        var intent = Intent(this, TransitionActivity::class.java)
        intent.putExtra(TransitionActivity.EXTRA_FROM, TransitionActivity.EXTRA_FROM_VALUE_API_21)
        var options = ActivityOptionsCompat.makeSceneTransitionAnimation(this)
        ActivityCompat.startActivity(this, intent, options.toBundle())
    }

    private fun startActivityWithSharedElements() {
        val intent = Intent(this, TransitionActivity::class.java)
        intent.putExtra(TransitionActivity.EXTRA_FROM, TransitionActivity.EXTRA_FROM_VALUE_API_21)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, "imageview")
        // val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(imageView, "imageview"))
        ActivityCompat.startActivity(this, intent, options.toBundle())
    }
}