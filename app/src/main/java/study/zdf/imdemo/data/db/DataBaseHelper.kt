package study.zdf.imdemo.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import study.zdf.imdemo.app.ImApplication

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/12/14 21:08
 */
class DataBaseHelper(
    ctx: Context = ImApplication.instance
    ) :
    ManagedSQLiteOpenHelper(ctx, NAME, null, VERSION) {
    companion object {
        const val NAME = "im.db"
        const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
            Contact.NAME, true, Contact.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT
            , Contact.CONTACT to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(Contact.NAME,true)
        onCreate(db)
    }
}