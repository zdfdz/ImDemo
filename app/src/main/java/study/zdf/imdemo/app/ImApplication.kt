package study.zdf.imdemo.app

import android.app.Application
import com.hyphenate.chat.EMClient
import com.hyphenate.chat.EMOptions
import study.zdf.imdemo.BuildConfig

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 17:41
 */
class ImApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        // 环信服务器的初始化
        EMClient.getInstance().init(applicationContext, EMOptions())
        //打包时关闭debug模式
        EMClient.getInstance().setDebugMode(BuildConfig.DEBUG)
    }
}