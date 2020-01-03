package cn.paper.library

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

abstract class PPFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(javaClass.simpleName, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(javaClass.simpleName, "onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(javaClass.simpleName, "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(javaClass.simpleName, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(javaClass.simpleName, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(javaClass.simpleName, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(javaClass.simpleName, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(javaClass.simpleName, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(javaClass.simpleName, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(javaClass.simpleName, "onDetach")
    }

}
