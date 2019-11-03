package study.zdf.imdemo.presenter

import android.view.View
import com.itheima.im.extentions.isValidPassword
import com.itheima.im.extentions.isValidUserName
import study.zdf.imdemo.contract.RegisterContract

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/3 16:36
 */
class RegisterPresenter(val view: RegisterContract.View) : RegisterContract.Presenter {
    override fun register(userName: String, pwd: String, confirmPwd: String) {
        if (userName.isValidUserName()) {
            if (pwd.isValidPassword()) {
                if (pwd.equals(confirmPwd)) {
                    //符合登录条件
                    view.onStartRegister()
                    //实现登录的逻辑
                } else view.onConfirmPwdError()
            } else view.onPwdError()
        } else view.onUserNameError()
    }
}