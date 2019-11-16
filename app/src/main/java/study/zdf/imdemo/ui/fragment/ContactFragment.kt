package study.zdf.imdemo.ui.fragment

import android.view.View
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.header.*
import study.zdf.imdemo.R

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/7 23:16
 */
class ContactFragment : BaseFragment() {
    override fun getLayoutResID(): Int {
        return R.layout.fragment_contacts
    }

    override fun init() {
        headerTitle.text = getString(R.string.contact)
        add.visibility = View.VISIBLE

        swipeRefreshLayout.apply {
            setColorSchemeResources(R.color.colorPrimary)
            isRefreshing = true
        }
    }
}