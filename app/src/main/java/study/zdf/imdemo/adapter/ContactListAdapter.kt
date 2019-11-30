package study.zdf.imdemo.adapter

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hyphenate.chat.EMClient
import org.jetbrains.anko.startActivity
import study.zdf.imdemo.Bean.ContactItemBean
import study.zdf.imdemo.R
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

        itemView.setOnLongClickListener {
            val msg = String.format(mContext.getString(R.string.delete_friend_message),contactItemsList[p1].userName)
            AlertDialog.Builder(mContext)
                .setTitle(R.string.delete_friend_title)
                .setMessage(msg)
                .setNegativeButton(R.string.cancel,null)
                .setPositiveButton(R.string.confirm, DialogInterface.OnClickListener { dialog, which ->
                    deletedFriend(contactItemsList[p1].userName)
                }).show()
            true
        }
    }

    /**
     * 删除好友逻辑
     */
    private fun deletedFriend(userName: String) {
        EMClient.getInstance().contactManager().deleteContact(userName)
    }

    class ContactListHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }
}