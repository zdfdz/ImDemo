package study.zdf.imdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.startActivity
import study.zdf.imdemo.Bean.ContactItemBean
import study.zdf.imdemo.ui.activity.ChatActivity

import study.zdf.imdemo.widget.ContactItemView

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/17 0:02
 */
class ContactListAdapter(val mContext:Context,val contactItemsList: MutableList<ContactItemBean>) :
    RecyclerView.Adapter<ContactListAdapter.ContactListHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactListHolder {
        return ContactListHolder(ContactItemView(p0.context))
    }

    override fun getItemCount(): Int {
        return contactItemsList.size
    }

    override fun onBindViewHolder(p0: ContactListHolder, p1: Int) {
        val itemView = p0.itemView as ContactItemView
        itemView.bindView(contactItemsList[p1])
        itemView.setOnClickListener {
            mContext.startActivity<ChatActivity>("username" to contactItemsList[p1].userName)
        }
    }

    class ContactListHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }
}