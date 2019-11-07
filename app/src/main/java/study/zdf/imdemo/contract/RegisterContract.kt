package study.zdf.imdemo.contract

/**
 * @author ZhengDeFeng
 * @description:注册界面协议类
 * @date :2019/11/3 15:53
 */
interface RegisterContract {
    interface Presenter : BasePresenter {
        fun register(userName: String, pwd: String, confirmPwd: String)
    }
    interface View{
        fun onUserNameError()
        fun onPwdError()
        fun onConfirmPwdError()
        fun onStartRegister()
        fun onRegisterSuccess()
        fun onRegisterFailed()
        fun onUserNameExis()
    }

}