package cn.paper.android.animations

import android.os.Bundle
import android.view.MenuItem
import cn.paper.android.R
import cn.paper.library.PPActivity

class TransitionActivity : PPActivity() {

    private var from: Int = EXTRA_FROM_VALUE_NONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        from = intent.getIntExtra(EXTRA_FROM, EXTRA_FROM_VALUE_NONE)

        setContentView(R.layout.activity_transition)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            if (from == EXTRA_FROM_VALUE_API_21) {
                supportFinishAfterTransition()
            } else {
                finish()
            }
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if(from == EXTRA_FROM_VALUE_API_21) {
            supportFinishAfterTransition()
        } else {
            super.onBackPressed()
        }
    }

    override fun finish() {
        super.finish()
        if (from == EXTRA_FROM_VALUE_DEFAULT) {
            overridePendingTransition(R.anim.keep_animation, R.anim.close_exit_animation)
        }
    }

    companion object {
        val EXTRA_FROM = "cn.paper.android.EXTRA_FROM"
        val EXTRA_FROM_VALUE_NONE = -1
        val EXTRA_FROM_VALUE_DEFAULT = 0
        val EXTRA_FROM_VALUE_API_21 = 1
    }
}