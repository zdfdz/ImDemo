package study.zdf.imdemo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import study.zdf.imdemo.R

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/16 23:38
 */
class ContactItemVie :RelativeLayout{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    init {
        View.inflate(context, R.layout.view_contact_item,this)
    }
}