package study.zdf.imdemo.contract

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/17 17:10
 */
interface ContactContract {
    interface Presenter:BasePresenter{
        fun loadContacts()
    }

    interface View{
        fun onLoadContactsSuccess()
        fun onLoadContactsFailed()
    }
}