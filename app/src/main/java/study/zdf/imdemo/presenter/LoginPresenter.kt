package study.zdf.imdemo.presenter

import com.hyphenate.EMCallBack
import com.hyphenate.chat.EMClient
import com.itheima.im.extentions.isValidPassword
import com.itheima.im.extentions.isValidUserName
import study.zdf.imdemo.adapter.EMCallBackAdapter
import study.zdf.imdemo.contract.LoginContract

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 20:24
 */
class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {
    override fun login(userName: String, pwd: String) {
        if (userName.isValidUserName()) {
//            用户名合法,开始校验密码
            if (pwd.isValidPassword()) {
                //开始走登录逻辑
                view.startLogin()
                LoginEaseMob(userName, pwd) //登录到环信
            } else view.userPwdError()
        } else {
            view.userNameError()
        }
    }


    /**
     * model层操作
     */
    private fun LoginEaseMob(userName: String, pwd: String) {
        EMClient.getInstance().login(userName, pwd, object : EMCallBackAdapter() {
            //            在子线程回调的
            override fun onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups()
                EMClient.getInstance().chatManager().loadAllConversations()
                //在子线程中通知view层
                uiThread { view.onLoggedInSuccess() }
            }

            override fun onError(p0: Int, p1: String?) {
                uiThread { view.onLoggedInFailed() }
            }
        })
    }
}