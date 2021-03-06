package study.zdf.imdemo.app

import android.app.Application
import android.support.multidex.MultiDexApplication
import cn.bmob.v3.Bmob
import com.hyphenate.chat.EMClient
import com.hyphenate.chat.EMOptions
import study.zdf.imdemo.BuildConfig

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/10/27 17:41
 */
class ImApplication : MultiDexApplication() {
    companion object {
        // lateinit 代表创建的时候没有这个对象，需要在后面进行初始化
        lateinit var instance: ImApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val options = EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.acceptInvitationAlways = false
        // 是否自动将消息附件上传到环信服务器，默认为True是使用环信服务器上传下载，如果设为 false，需要开发者自己处理附件消息的上传和下载
        options.autoTransferMessageAttachments = true
        // 是否自动下载附件类消息的缩略图等，默认为 true 这里和上边这个参数相关联
        options.setAutoDownloadThumbnail(true)
        //初始化  test分支二
        EMClient.getInstance().init(applicationContext, options)
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true)

        Bmob.initialize(this, "fc5a83a016073f4b66745dda050ab7be")
    }
}