package bean;

import java.util.List;

/**
 * Created by sucheng
 * on 2018/4/27.
 */
public class ReturnDataBean {
    List list;
    String code;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ReturnDataBean{" +
                "list=" + list +
                ", code='" + code + '\'' +
                '}';
    }
}
