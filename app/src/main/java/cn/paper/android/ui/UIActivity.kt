package cn.paper.android.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import cn.paper.android.R
import cn.paper.library.PPActivity

class UIActivity : PPActivity(), View.OnClickListener {

    private lateinit var btnViewPager: Button
    private lateinit var btnViewPager2: Button
    private lateinit var btnBanner: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui)

        btnViewPager = findViewById(R.id.btnViewPager)
        btnViewPager.setOnClickListener(this)

        btnViewPager2 = findViewById(R.id.btnViewPager2)
        btnViewPager2.setOnClickListener(this)

        btnBanner = findViewById(R.id.btnBanner)
        btnBanner.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            val intent = Intent()

            if (it.id == R.id.btnViewPager) {
                intent.setClass(this, ViewPagerActivity::class.java)
            } else if (it.id == R.id.btnViewPager2) {
                intent.setClass(this, ViewPager2Activity::class.java)
            } else if (it.id == R.id.btnBanner) {
                intent.setClass(this, BannerActivity::class.java)
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}
