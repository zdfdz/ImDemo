package study.zdf.imdemo.ui.fragment

import com.hyphenate.chat.EMClient
import kotlinx.android.synthetic.main.fragment_dynamic.*
import kotlinx.android.synthetic.main.header.*
import com.hyphenate.EMCallBack
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import study.zdf.imdemo.ui.activity.LoginActivity


/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/7 23:16
 */
class DynamicFragment :BaseFragment() {
    override fun getLayoutResID(): Int {
        return study.zdf.imdemo.R.layout.fragment_dynamic
    }

    override fun init() {
        super.init()
        headerTitle.text = getString(study.zdf.imdemo.R.string.dynamic)
        val loginString = String.format(getString(study.zdf.imdemo.R.string.logout),EMClient.getInstance().currentUser)
        logout.text = loginString

        logout.setOnClickListener {
            exitLogin()
        }
    }

    private fun exitLogin() {
        EMClient.getInstance().logout(true, object : EMCallBack {

            override fun onSuccess() {
                context?.startActivity<LoginActivity>()
                activity?.finish()

            }

            override fun onProgress(progress: Int, status: String) {


            }

            override fun onError(code: Int, message: String) {
            //切换到主线程
                context?.runOnUiThread {
                    toast("退出失败")
                }

            }
        })
    }


}