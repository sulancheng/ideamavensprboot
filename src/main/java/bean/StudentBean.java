package bean;

import java.util.List;

/**
 * Created by sucheng
 * on 2018/5/5.
 */
public class StudentBean <T>{
    private String banji;
    private List<T> list;

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
