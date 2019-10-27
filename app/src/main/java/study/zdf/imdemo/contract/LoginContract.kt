package study.zdf.imdemo.contract

/**
 * @author ZhengDeFeng
 * @description: 登录界面协议类
 * @date :2019/10/27 20:01
 */
interface LoginContract {
    interface Presenter : BasePresenter {
        fun login(userName: String, pwd: String)
    }

    interface View {
        fun userNameError()//用户名错误
        fun userPwdError()//密码错误
        fun startLogin()//点击login后,页面跳转前的ui显示
        fun onLoggedInSuccess()//登录成功
        fun onLoggedInFailed()//登录失败
    }
}