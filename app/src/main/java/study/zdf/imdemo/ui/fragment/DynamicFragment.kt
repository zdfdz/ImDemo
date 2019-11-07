package study.zdf.imdemo.ui.fragment

import study.zdf.imdemo.R

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/7 23:16
 */
class DynamicFragment :BaseFragment() {
    override fun getLayoutResID(): Int {
        return R.layout.fragment_dynamic
    }
}