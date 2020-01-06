package cn.paper.android.activities

import android.content.Context
import android.view.View
import cn.paper.android.activities.Demo

class Demo {
    fun haha(context: Context?) {
        val view = View(context)
        view.setOnClickListener { test(this@Demo) }
    }

    fun test(demo: Demo?) {}
}