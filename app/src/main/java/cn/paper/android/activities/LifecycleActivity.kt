package cn.paper.android.activities

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import cn.paper.android.R
import cn.paper.library.PPActivity
import cn.paper.library.PPDialogActivity

class LifecycleActivity : PPActivity(), View.OnClickListener {

    private lateinit var btnDialog: Button

    private val requestDialogCode: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        btnDialog = findViewById(R.id.btnDialog)
        btnDialog.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
//        showDialog()
        showDialogViaActivity()
    }

    private fun showDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage("messge").setTitle("title")
        builder.apply {
            setTitle("title")
            setMessage("message")
            setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                Log.d(javaClass.simpleName, "click positive action + ${which}")
            })
            setNegativeButton("cancel", null)
        }

        val dialg: AlertDialog = builder.create()
        dialg.show()
    }

    private fun showDialogViaActivity() {
        val intent = Intent(this, PPDialogActivity::class.java)
        intent.putExtra(PPDialogActivity.EXTRA_DIALOG_TITLE, "title")
        intent.putExtra(PPDialogActivity.EXTRA_DIALOG_MESSAGE, "message")
        intent.putExtra(PPDialogActivity.EXTRA_DIALOG_POSITIVE, "ok")
        intent.putExtra(PPDialogActivity.EXTRA_DIALOG_NEGATIVE, "cancel")
        startActivityForResult(intent, requestDialogCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == requestDialogCode) {
            if (data != null && data.hasExtra(PPDialogActivity.RESULT_DIALOG_WHICH)) {
                val which = data.getIntExtra(PPDialogActivity.RESULT_DIALOG_WHICH, PPDialogActivity.RESULT_DIALOG_WHICH_NEGATIVE)
                Log.d(javaClass.simpleName, "resultCode = $resultCode, which = $which")
            }
        }
    }
}