package cn.paper.android.activities

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AlertDialog
import cn.paper.library.PPActivity

class DialogActivity : PPActivity(), DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

    private val dialogList: MutableList<DialogParams> = ArrayList()
    private var currentDialogParams: DialogParams? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pushDialog()
    }

    private fun pushDialog() {
        val params = DialogParams()
        params.id = intent.getLongExtra(EXTRA_DIALOG_ID, -1)
        params.title = intent.getStringExtra(EXTRA_DIALOG_TITLE)
        params.message = intent.getStringExtra(EXTRA_DIALOG_MESSAGE)
        params.positiveButtonText = intent.getStringExtra(EXTRA_DIALOG_POSITIVE)
        params.negativeButtonText = intent.getStringExtra(EXTRA_DIALOG_NEGATIVE)
        params.neutralButtonText = intent.getStringExtra(EXTRA_DIALOG_NEUTRA)
        dialogList.add(params)

        showDialog()
    }

    private fun showDialog() {
        currentDialogParams = dialogList.removeAt(0)
        currentDialogParams?.let {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle(it.title).setMessage(it.message)
            if (!TextUtils.isEmpty(it.positiveButtonText)) {
                builder.setPositiveButton(it.positiveButtonText!!, this)
            }

            if (!TextUtils.isEmpty(it.negativeButtonText)) {
                builder.setNegativeButton(it.negativeButtonText!!, this)
            }

            if (!TextUtils.isEmpty(it.neutralButtonText)) {
                builder.setNeutralButton(it.neutralButtonText!!, this)
            }

            builder.setOnDismissListener(this)
            builder.show()
        }
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        var data = Intent()
        data.putExtra(RESULT_DIALOG_WHICH, which)
        setResult(Activity.RESULT_OK, data)
    }

    override fun onDismiss(dialog: DialogInterface?) {
        if (dialogList.size > 0) {
            showDialog()
        } else {
            finish()
            overridePendingTransition(0, 0)
        }
    }

    companion object {
        val EXTRA_DIALOG_TITLE = "cn.paper.library.dialog.extra.DIALOG_TITLE"
        val EXTRA_DIALOG_MESSAGE = "cn.paper.library.dialog.extra.DIALOG_MESSAGE"
        val EXTRA_DIALOG_POSITIVE = "cn.paper.library.dialog.extra.DIALOG_POSITIVE"
        val EXTRA_DIALOG_NEGATIVE = "cn.paper.library.dialog.extra.DIALOG_NEGATIVE"
        val EXTRA_DIALOG_NEUTRA = "cn.paper.library.dialog.extra.DIALOG_NEUTRA"
        val EXTRA_DIALOG_ID = "cn.paper.library.dialog.extra.DIALOG_ID"

        val RESULT_DIALOG_WHICH = "cn.paper.library.dialog.extra.DIALOG_WHICH"
        val RESULT_DIALOG_WHICH_POSITIVE = DialogInterface.BUTTON_POSITIVE
        val RESULT_DIALOG_WHICH_NEGATIVE = DialogInterface.BUTTON_NEGATIVE
        val RESULT_DIALOG_WHICH_NEUTRA = DialogInterface.BUTTON_NEUTRAL

        class DialogParams {
            var id: Long = -1
            var title: CharSequence? = null
            var message: CharSequence? = null

            var positiveButtonText: CharSequence? = null
            var negativeButtonText: CharSequence? = null
            var neutralButtonText: CharSequence? = null
        }
    }
}