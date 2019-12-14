package cn.paper.android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import cn.paper.android.activities.ActivitiesActivity
import cn.paper.android.ui.UIActivity
import cn.paper.library.PPActivity

class MainActivity : PPActivity(), View.OnClickListener {

     lateinit var btnActivities: Button
    private lateinit var btnUI: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setContentView(R.layout.activity_main)

        btnActivities = findViewById(R.id.btnActivities)
        btnActivities.setOnClickListener(this)

        btnUI = findViewById(R.id.btnUI)
        btnUI.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            val intent = Intent()
            if (it.id == R.id.btnActivities) {
                intent.setClass(this, ActivitiesActivity::class.java)
            } else if (it.id == R.id.btnUI){
                intent.setClass(this, UIActivity::class.java)
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}
