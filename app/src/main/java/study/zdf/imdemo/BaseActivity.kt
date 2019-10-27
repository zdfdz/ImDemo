package study.zdf.imdemo

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 11:47
 */
abstract class BaseActivity : AppCompatActivity() {
    val progressDialog by lazy { ProgressDialog(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResID())
        init()
    }

    /**
     * 创建弹出进度条
     */
    fun showProgress(message: String) {
        progressDialog.setMessage(message)
        progressDialog.show()
    }

    /**
     * 关闭进度条dialog显示
     */
    fun dismissProgress() {
        progressDialog.dismiss()
    }

    /**
     * 初始化公共功能
     */
    open fun init() {

    }


    abstract fun getLayoutResID(): Int
}