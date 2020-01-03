package cn.paper.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem

open class PPActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Log.d(this.javaClass.simpleName, "onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(this.javaClass.simpleName, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(this.javaClass.simpleName, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(this.javaClass.simpleName, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(this.javaClass.simpleName, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(this.javaClass.simpleName, "onDestroy()")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            supportFragmentManager?.let {
                if (it.backStackEntryCount > 0) {
                    it.popBackStack()
                    return true
                }
            }
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
