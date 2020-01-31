package study.zdf.imdemo.dagger2.module

import dagger.Module
import dagger.Provides
import study.zdf.imdemo.presenter.ContactPresenter
import study.zdf.imdemo.ui.fragment.ContactFragment

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/12/22 10:08
 */
@Module
class ContactFragmentModule(private val contactFragment: ContactFragment) {
    @Provides
    fun provideContactFragmentPresent(): ContactPresenter {
        return ContactPresenter(contactFragment)
    }
}