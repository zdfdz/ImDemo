package study.zdf.imdemo.factory

import android.support.v4.app.Fragment
import study.zdf.imdemo.R
import study.zdf.imdemo.ui.fragment.ContactFragment
import study.zdf.imdemo.ui.fragment.ConversationFragment
import study.zdf.imdemo.ui.fragment.DynamicFragment

/**
 * @author ZhengDeFeng
 * @description:这是kotlin的单例模式，构造一个私有的构造方法
 * @date :2019/11/7 23:28
 */
class fragmentFactory private constructor() {
    private val mConversationFragment by lazy { ConversationFragment() }
    private val mDynamicFragment by lazy { DynamicFragment() }
    private val mContactFragment by lazy { ContactFragment() }

    companion object {
        val instance by lazy { fragmentFactory() }
    }

    fun getFragment(tabId: Int): Fragment {
        when (tabId) {
            R.id.tab_dynamic -> return mDynamicFragment
            R.id.tab_contacts -> return mContactFragment
            R.id.tab_conversation -> return mConversationFragment
        }
        return mConversationFragment
    }
}