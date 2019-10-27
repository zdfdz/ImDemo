package study.zdf.imdemo.presenter

import study.zdf.imdemo.contract.SplashContract

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 16:52
 */
class SplashPresenter(val view:SplashContract.View): SplashContract.Presenter {
    override fun checkLoginStatus() {
        if (isLoggedIn()) view.onLoggedIn()
        else view.onNotLoggedIn()
    }

    private fun isLoggedIn(): Boolean {
        return false
    }
}