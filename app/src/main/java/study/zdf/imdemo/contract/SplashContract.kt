package study.zdf.imdemo.contract

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 16:25
 */
interface SplashContract {
    interface Presenter : BasePresenter {
        fun checkLoginStatus()//检查登录状态
    }

    interface View{
        fun onNotLoggedIn() //没有登录业务逻辑
        fun onLoggedIn() //登录过的业务处理
    }

}