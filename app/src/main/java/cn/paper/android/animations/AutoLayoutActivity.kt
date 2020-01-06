package cn.paper.android.animations

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import cn.paper.android.R
import cn.paper.library.PPActivity

class AutoLayoutActivity : PPActivity() {

    private lateinit var layout: ViewGroup
    private lateinit var textView: TextView
    private lateinit var btnAnimate: Button
    private lateinit var btnAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_autolayout)

        layout = findViewById(R.id.layout)

        textView = findViewById(R.id.textView)

        btnAnimate = findViewById(R.id.btnAnimate)
        btnAnimate.setOnClickListener {
            textView.visibility = if (textView.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }

        btnAdd = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            var view = TextView(this)
            view.setText("haha")
            layout.addView(view)
        }
    }
}