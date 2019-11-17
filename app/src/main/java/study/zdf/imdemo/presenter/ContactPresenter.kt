package study.zdf.imdemo.presenter

import study.zdf.imdemo.contract.ContactContract
import com.hyphenate.chat.EMClient
import org.jetbrains.anko.doAsync


/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/17 17:37
 */
class ContactPresenter(val view: ContactContract.View) : ContactContract.Presenter {
    override fun loadContacts() {
        doAsync {
            try {
                val usernames = EMClient.getInstance().contactManager().allContactsFromServer
                view.onLoadContactsSuccess()
            } catch (e: Exception) {
                view.onLoadContactsFailed()
            }
        }
    }
}