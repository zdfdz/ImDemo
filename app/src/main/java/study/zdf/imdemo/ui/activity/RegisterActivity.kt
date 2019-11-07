package study.zdf.imdemo.ui.activity

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import study.zdf.imdemo.R
import study.zdf.imdemo.contract.RegisterContract
import study.zdf.imdemo.presenter.RegisterPresenter

/**
 * @author ZhengDeFeng
 * @description: 注册界面
 * @date :2019/11/3 15:01
 */
class RegisterActivity : BaseActivity(), RegisterContract.View {
    override fun onUserNameExis() {
        Toast.makeText(this,"用户名已经存在",Toast.LENGTH_LONG).show()
    }

    private val mPresenter by lazy { RegisterPresenter(this) }

    override fun init() {
        super.init()

        register.setOnClickListener {
            val name = userName.text.trim().toString()
            val pwd = password.text.trim().toString()
            val cfpwd = confirmPassword.text.trim().toString()
            mPresenter.register(name, pwd, cfpwd)
        }

    }

    override fun getLayoutResID(): Int {
        return R.layout.activity_register
    }

    override fun onUserNameError() {
        userName.error = "用户名不正确"
    }

    override fun onPwdError() {
        password.error = "密码错误"
    }

    override fun onConfirmPwdError() {
        confirmPassword.error = "密码确认有误"
    }

    override fun onStartRegister() {
        showProgress("正在注册")
//        finish()
    }

    override fun onRegisterSuccess() {
        dismissProgress()
        finish()
    }

    override fun onRegisterFailed() {
        Toast.makeText(this, "注册失败", Toast.LENGTH_LONG).show()
    }


}