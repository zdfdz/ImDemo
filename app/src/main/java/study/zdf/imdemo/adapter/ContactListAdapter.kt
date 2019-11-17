package study.zdf.imdemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import study.zdf.imdemo.Bean.ContactItemBean
import study.zdf.imdemo.widget.ContactItemVie

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/17 0:02
 */
class ContactListAdapter(val contactItemsList: MutableList<ContactItemBean>) :
    RecyclerView.Adapter<ContactListAdapter.ContactListHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactListHolder {
        return ContactListHolder(ContactItemVie(p0.context))
    }

    override fun getItemCount(): Int {
        return contactItemsList.size
    }

    override fun onBindViewHolder(p0: ContactListHolder, p1: Int) {
        val itemView = p0.itemView as ContactItemVie
        itemView.bindView(contactItemsList[p1])
    }

    class ContactListHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}