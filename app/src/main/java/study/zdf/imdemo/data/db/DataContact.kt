package study.zdf.imdemo.data.db

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/12/14 21:24
 */

data class DataContact(val map:MutableMap<String,Any?>){
    // 委托模式的应用
    val _id by map
    val name by map
}