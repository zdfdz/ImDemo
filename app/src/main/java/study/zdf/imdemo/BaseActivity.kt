package study.zdf.imdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 11:47
 */
abstract  class BaseActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResID())
        init()
    }

    /**
     * 初始化公共功能
     */
    open fun init() {

    }


    abstract fun getLayoutResID(): Int
}