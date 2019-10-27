package study.zdf.imdemo.contract

import android.os.Handler
import android.os.Looper

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 16:23
 */

interface BasePresenter {
    companion object {
        val mHandler by lazy { Handler(Looper.getMainLooper()) }
    }

    //线程切换
    fun uiThread(f: () -> Unit) {
        mHandler.post(object :Runnable{
            override fun run() {
               f()
            }

        })
    }

}