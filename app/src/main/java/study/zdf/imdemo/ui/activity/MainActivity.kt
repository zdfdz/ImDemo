package study.zdf.imdemo.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import study.zdf.imdemo.R
import study.zdf.imdemo.factory.fragmentFactory

class MainActivity :BaseActivity() {
    override fun getLayoutResID(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        super.init()
        bottomBar.setOnTabSelectListener {
            tabId ->
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_frame,fragmentFactory.instance.getFragment(tabId))
            transaction.commit()
        }
    }

}
