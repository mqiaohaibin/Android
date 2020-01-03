package cn.paper.android.activities

import android.os.Bundle
import cn.paper.android.R
import cn.paper.android.fragment.LifecycleFragment
import cn.paper.library.PPActivity

class FragmentActivity : PPActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        var transaction = supportFragmentManager.beginTransaction();
        var fragment:LifecycleFragment = LifecycleFragment.newInstance()

        transaction.add(R.id.container, fragment)
        transaction.commit()
    }
}
