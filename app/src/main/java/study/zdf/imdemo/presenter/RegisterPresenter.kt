package study.zdf.imdemo.presenter

import android.view.View
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.SaveListener
import com.itheima.im.extentions.isValidPassword
import com.itheima.im.extentions.isValidUserName
import kotlinx.android.synthetic.main.activity_login.view.*
import study.zdf.imdemo.Bean.loginBean
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
                    registerBmob(userName, pwd)
                } else view.onConfirmPwdError()
            } else view.onPwdError()
        } else view.onUserNameError()
    }

    /**
     * 注册用户名 密码
     */
    private fun registerBmob(userName: String, pwd: String) {
        val loginBean = loginBean()
        loginBean.name = userName
        loginBean.address=pwd
        loginBean.save(object :SaveListener<String>(){
            override fun done(p0: String?, p1: BmobException?) {
                if (p1==null){
                    //添加数据成功
                    //注册到环信
                }else {
                    // 添加数据失败
                }
            }
        })
    }
}