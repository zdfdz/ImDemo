package study.zdf.imdemo

import android.view.KeyEvent
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import study.zdf.imdemo.contract.LoginContract
import study.zdf.imdemo.presenter.LoginPresenter

/**
 * @author ZhengDeFeng
 * @description:登录界面的ui层实现
 * @date :2019/10/27 16:41
 */
class LoginActivity : BaseActivity(), LoginContract.View {
    private val mPresenter by lazy { LoginPresenter(this) }

    override fun getLayoutResID(): Int {
        return R.layout.activity_login
    }

    override fun init() {
        login.setOnClickListener {
            login()
        }
        password.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                login()
                return true
            }
        })
    }

    private fun login() {
        hideSoftKeyboard()
        val userName = userName.text.trim().toString()
        val userPwd = password.text.trim().toString()
        mPresenter.login(userName, userPwd)
    }

    override fun userNameError() {
        userName.error = getString(R.string.user_name_error)
    }

    override fun userPwdError() {
        password.error = getString(R.string.password_error)
    }

    override fun startLogin() {
        //弹出进度条
        showProgress(getString(R.string.logging))
    }

    override fun onLoggedInSuccess() {
        //隐藏进度条
        dismissProgress()
        //进入主界面
        startActivity<MainActivity>()
        //退出activity
        finish()
    }

    override fun onLoggedInFailed() {
        //隐藏进度条
        dismissProgress()
        Toast.makeText(this, "登录失败", Toast.LENGTH_LONG).show()
    }


}