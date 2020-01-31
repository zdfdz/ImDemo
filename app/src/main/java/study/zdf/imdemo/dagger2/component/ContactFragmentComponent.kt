package study.zdf.imdemo.dagger2.component

import dagger.Component
import study.zdf.imdemo.dagger2.module.ContactFragmentModule
import study.zdf.imdemo.ui.fragment.ContactFragment

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/12/22 10:19
 */
@Component(modules = [ContactFragmentModule::class])
interface ContactFragmentComponent {
    fun inject(contactFragment: ContactFragment)
}