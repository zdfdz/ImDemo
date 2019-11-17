package study.zdf.imdemo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_contact_item.view.*
import study.zdf.imdemo.Bean.ContactItemBean
import study.zdf.imdemo.R

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/16 23:38
 */
class ContactItemView :RelativeLayout{
    fun bindView(itemBean: ContactItemBean) {
        firstLetter.text = itemBean.firstLetter.toString()
        userName.text = itemBean.userName
        if (itemBean.showFirstLetter){
            firstLetter.visibility = View.VISIBLE
        }else
        {
            firstLetter.visibility = View.GONE
        }

    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    init {
        View.inflate(context, R.layout.view_contact_item,this)
    }
}