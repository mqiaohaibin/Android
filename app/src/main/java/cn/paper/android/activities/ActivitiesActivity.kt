package cn.paper.android.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import cn.paper.android.R
import cn.paper.library.PPActivity

class ActivitiesActivity : PPActivity(), View.OnClickListener {

    private lateinit var btnLifecycle: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities)
        btnLifecycle = findViewById(R.id.btnLifecyle)
        btnLifecycle.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent = Intent(this, LifecycleActivity::class.java)
        startActivity(intent)
    }
}