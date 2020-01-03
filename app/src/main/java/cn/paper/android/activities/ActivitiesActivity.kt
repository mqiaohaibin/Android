package cn.paper.android.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import cn.paper.android.R
import cn.paper.library.PPActivity

class ActivitiesActivity : PPActivity(), View.OnClickListener {

    private lateinit var btnActivityLifecycle: Button
    private lateinit var btnFragmentLifecycle: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities)

        btnActivityLifecycle = findViewById(R.id.btnActivityLifecyle)
        btnActivityLifecycle.setOnClickListener(this)

        btnFragmentLifecycle = findViewById(R.id.btnFragmentLifecycle)
        btnFragmentLifecycle.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            val intent = Intent()
            if (it.id == R.id.btnActivityLifecyle) {
                intent.setClass(this, LifecycleActivity::class.java)
            } else if (it.id == R.id.btnFragmentLifecycle) {
                intent.setClass(this, FragmentActivity::class.java)
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}