package cn.paper.android.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import cn.paper.android.R
import cn.paper.library.PPFragment

class DemoFragment private constructor() : PPFragment(), View.OnClickListener {


    private lateinit var btnNext: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d(javaClass.simpleName, "onCreateView")
        var view = inflater.inflate(R.layout.fragment_lifecycle, container, false)
        view.setBackgroundColor(Color.RED)
        btnNext = view.findViewById(R.id.btnNext)
        btnNext.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        activity?.supportFragmentManager?.let {
            var fragment = LifecycleFragment.newInstance()
            it.beginTransaction().apply {
                setCustomAnimations(R.anim.open_enter_animation, R.anim.open_exit_animation, R.anim.close_enter_animation, R.anim.close_exit_animation)
                replace(R.id.container, fragment)
                addToBackStack(null)
                commitAllowingStateLoss()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DemoFragment()
    }
}
