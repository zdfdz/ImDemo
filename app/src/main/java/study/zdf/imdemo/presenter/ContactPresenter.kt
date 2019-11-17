package study.zdf.imdemo.presenter

import study.zdf.imdemo.contract.ContactContract
import com.hyphenate.chat.EMClient
import org.jetbrains.anko.doAsync
import study.zdf.imdemo.Bean.ContactItemBean


/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/17 17:37
 */
class ContactPresenter(val view: ContactContract.View) : ContactContract.Presenter {
    val contactItemsList = mutableListOf<ContactItemBean>()
    override fun loadContacts() {
        doAsync {
            try {
                val usernames = EMClient.getInstance().contactManager().allContactsFromServer
                // 根据首字符排序
                usernames.sortBy { it[0] }

                usernames.forEachIndexed { index, s ->
                    //判断是否显示首字符
                    val showFirstLetter = index == 0 || s[0] != usernames[index - 1][0]
                    val contactListItem = ContactItemBean(s, s[0].toUpperCase(), showFirstLetter)
                    contactItemsList.add(contactListItem)
                }
                view.onLoadContactsSuccess()
            } catch (e: Exception) {
                view.onLoadContactsFailed()
            }
        }
    }
}