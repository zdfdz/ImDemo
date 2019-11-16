package study.zdf.imdemo.ui.fragment

import com.hyphenate.chat.EMClient
import kotlinx.android.synthetic.main.fragment_dynamic.*
import kotlinx.android.synthetic.main.header.*
import study.zdf.imdemo.R

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/7 23:16
 */
class DynamicFragment :BaseFragment() {
    override fun getLayoutResID(): Int {
        return R.layout.fragment_dynamic
    }

    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.dynamic)
        val loginString = String.format(getString(R.string.logout),EMClient.getInstance().currentUser)
        logout.text = loginString
    }
}