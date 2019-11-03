package study.zdf.imdemo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.view.KeyEvent
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
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
        newUser.setOnClickListener {
            registerNewUser()
        }

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

    /**
     * 新用户注册
     */
    private fun registerNewUser() {
        val intent = Intent(this,RegisterActivity::class.java)
        startActivity(intent)
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
        if (cheakWriteExternalPermission()) {
            //进入主界面
            startActivity<MainActivity>()
            //退出activity
            finish()
        } else {
            //申请权限
            applyWriteExternalPermission()
        }
    }

    /**
     * 申请权限
     */
    private fun applyWriteExternalPermission() {
        val premissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        ActivityCompat.requestPermissions(this, premissions, 0)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            login()
        } else {
            toast("为了更好的体验,我们需要这个权限")
        }
    }

    /**
     * 权限检查
     */
    private fun cheakWriteExternalPermission(): Boolean {
        val result = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        return result == PackageManager.PERMISSION_GRANTED
    }

    override fun onLoggedInFailed() {
        //隐藏进度条
        dismissProgress()
        Toast.makeText(this, "登录失败", Toast.LENGTH_LONG).show()
    }


}