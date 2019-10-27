package study.zdf.imdemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 11:51
 */
abstract class BaseFragment:Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResID(),null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    /**
     * view创建完成之后初始化公共功能
     */
    open fun init() {

    }

    abstract fun getLayoutResID(): Int
}