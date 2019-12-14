package study.zdf.imdemo.data.db

import com.itheima.im.extentions.toVarargArray
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/12/14 21:48
 */
class IMDatabase {
    companion object {
        val mDatabaseHelper = DataBaseHelper()
        val mInstance = IMDatabase()
    }

    fun saveContact(contact: DataContact) {
        // sqlite 的扩展方法
        mDatabaseHelper.use {
            // * 的作用是将 Pair 展开,变成可变参数
            insert(Contact.NAME, *contact.map.toVarargArray())
        }
    }

    fun getAllContacts(): List<DataContact> {
        return mDatabaseHelper.use {
            select(Contact.NAME).parseList(object : MapRowParser<DataContact> {
                override fun parseRow(columns: Map<String, Any?>): DataContact {
                    return DataContact(columns.toMutableMap())
                }
            })
        }
    }

    fun deleteAllContact(){
        mDatabaseHelper.use {
            delete(Contact.NAME,null,null)
        }
    }
}