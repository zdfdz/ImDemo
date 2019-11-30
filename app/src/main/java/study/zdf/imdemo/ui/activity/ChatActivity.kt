package study.zdf.imdemo.ui.activity

import kotlinx.android.synthetic.main.header.*
import study.zdf.imdemo.R

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/17 21:59
 */
class ChatActivity :BaseActivity() {
    override fun getLayoutResID(): Int {
        return R.layout.activity_chat
    }

    override fun init() {
        super.init()
        val strings = intent.getStringExtra("username")
        headerTitle.text = strings
    }
}