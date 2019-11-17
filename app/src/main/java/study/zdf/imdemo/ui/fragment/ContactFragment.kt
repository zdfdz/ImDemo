package study.zdf.imdemo.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.header.*
import org.jetbrains.anko.toast
import study.zdf.imdemo.R
import study.zdf.imdemo.adapter.ContactListAdapter
import study.zdf.imdemo.contract.ContactContract

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/7 23:16
 */
class ContactFragment : BaseFragment(), ContactContract.View {

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

        recyclerView.apply {
            //当确定recyclerView的内部布局大小不会再改变的时候设置为true，会有内部优化
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = ContactListAdapter()
        }
    }

    override fun onLoadContactsSuccess() {
        swipeRefreshLayout.isRefreshing = false
        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun onLoadContactsFailed() {
        swipeRefreshLayout.isRefreshing = false
        context?.toast("刷新失败")
    }
}