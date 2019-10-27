package study.zdf.imdemo

import android.os.Handler
import org.jetbrains.anko.startActivity
import study.zdf.imdemo.contract.SplashContract

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 12:12
 */
class SplashActivity : BaseActivity(), SplashContract.View {

    //伴生对象里都是静态的
    companion object {
        val DELAY: Long = 2000
    }

    private val mHandler by lazy { Handler() }

    override fun getLayoutResID(): Int {
        return R.layout.activity_splash
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