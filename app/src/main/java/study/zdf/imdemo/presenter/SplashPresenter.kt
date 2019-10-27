package study.zdf.imdemo.presenter

import com.hyphenate.chat.EMClient
import study.zdf.imdemo.contract.SplashContract

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 16:52
 */
class SplashPresenter(private val view: SplashContract.View) : SplashContract.Presenter {
    override fun checkLoginStatus() {
        if (isLoggedIn()) view.onLoggedIn()
        else view.onNotLoggedIn()
    }

    private fun isLoggedIn(): Boolean {
        return EMClient.getInstance().isConnected && EMClient.getInstance().isLoggedInBefore
    }
}