package study.zdf.imdemo

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 11:47
 */
abstract class BaseActivity : AppCompatActivity() {
    private val progressDialog by lazy { ProgressDialog(this) }
    val mInputMethodManage by lazy { getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResID())
        init()
    }
    /**
     * 隐藏软键盘
     */

    fun hideSoftKeyboard(){
        mInputMethodManage.hideSoftInputFromWindow(currentFocus.windowToken,0)
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