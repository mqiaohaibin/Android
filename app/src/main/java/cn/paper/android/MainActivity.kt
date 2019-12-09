package cn.paper.android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import cn.paper.android.activities.ActivitiesActivity
import cn.paper.library.PPActivity

class MainActivity : PPActivity(), View.OnClickListener {

    private lateinit var btnActivities: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setContentView(R.layout.activity_main)

        btnActivities = findViewById(R.id.btnActivities)
        btnActivities.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent = Intent(this, ActivitiesActivity::class.java)
        startActivity(intent)
    }
}
