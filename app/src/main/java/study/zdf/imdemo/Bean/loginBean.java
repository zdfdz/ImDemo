package study.zdf.imdemo.Bean;

import cn.bmob.v3.BmobObject;

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/7 21:59
 */
public class loginBean extends BmobObject {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
