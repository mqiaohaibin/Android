package cn.paper.android.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import cn.paper.android.R

private const val ARG_COLOR = "color"
private const val ARG_INDEX = "index"

class ColorFragment : Fragment() {
    private var color: Int? = null
    private var index: Int? = null

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(ARG_COLOR)
            index = it.getInt(ARG_INDEX)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.item_color, container, false)
        view.setBackgroundColor(color ?: Color.WHITE)

        textView = view.findViewById(R.id.textView)
        textView.setText(Integer.toString(index ?: 0))

        return view
    }

    companion object {

        fun newInstance(color: Int, index: Int) =
                ColorFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLOR, color)
                        putInt(ARG_INDEX, index)
                    }
                }
    }
}
