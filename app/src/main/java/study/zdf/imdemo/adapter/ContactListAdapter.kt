package study.zdf.imdemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import study.zdf.imdemo.widget.ContactItemVie

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/17 0:02
 */
class ContactListAdapter : RecyclerView.Adapter<ContactListAdapter.ContactListHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactListHolder {
        return ContactListHolder(ContactItemVie(p0.context))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(p0: ContactListHolder, p1: Int) {

    }

    class ContactListHolder(private val itemView:View) :RecyclerView.ViewHolder(itemView){

    }
}