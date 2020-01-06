package cn.paper.android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import cn.paper.android.activities.ActivitiesActivity
import cn.paper.android.animations.AnimationsActivity
import cn.paper.library.PPActivity

class MainActivity : PPActivity(), View.OnClickListener {

    private lateinit var btnActivities: Button
    private lateinit var btnAnimations: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setContentView(R.layout.activity_main)

        btnActivities = findViewById(R.id.btnActivities)
        btnActivities.setOnClickListener(this)

        btnAnimations = findViewById(R.id.btnAnimations)
        btnAnimations.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            if (it.id == R.id.btnActivities) {
                var intent = Intent(this, ActivitiesActivity::class.java)
                startActivity(intent)
            } else if (it.id == R.id.btnAnimations) {
                var intent = Intent(this, AnimationsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
