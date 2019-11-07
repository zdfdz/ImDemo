package study.zdf.imdemo.ui.activity

import android.os.Handler
import org.jetbrains.anko.startActivity
import study.zdf.imdemo.R
import study.zdf.imdemo.contract.SplashContract
import study.zdf.imdemo.presenter.SplashPresenter

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 12:12
 */
class SplashActivity : BaseActivity(), SplashContract.View {

    //伴生对象里都是静态的
    companion object {
        const val DELAY: Long = 2000
    }

    private val mSplashPresenter by lazy { SplashPresenter(this) }
    private val mHandler by lazy { Handler() }

    override fun getLayoutResID(): Int {
        return R.layout.activity_splash
    }

    //在splash界面检查状态
    override fun init() {
        mSplashPresenter.checkLoginStatus()
    }

    // 显示两秒，跳转到登录界面
    override fun onNotLoggedIn() {
        mHandler.postDelayed(object : Runnable {
            override fun run() {
                startActivity<LoginActivity>()
                finish()
            }
        }, DELAY)
    }

    //跳转到主界面
    override fun onLoggedIn() {
        startActivity<MainActivity>()
    }
}