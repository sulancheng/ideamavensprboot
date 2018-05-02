package bean;

/**
 * Created by Administrator
 * on 2018/5/2.
 */
//统一返回数据的类型
public class Result<T> {
    //错误码
    private Integer code;
    private String msg;//错误信息
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
