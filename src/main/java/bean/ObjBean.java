package bean;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator
 * on 2018/5/10.
 */

public class ObjBean<T> {
    private List<T> datalist;
    private Map<Object,ObjBean> map;

    public List<T> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<T> datalist) {
        this.datalist = datalist;
    }

    public Map<Object, ObjBean> getMap() {
        return map;
    }

    public void setMap(Map<Object, ObjBean> map) {
        this.map = map;
    }
}
