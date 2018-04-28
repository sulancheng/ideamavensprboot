package bean;

/**
 * Created by Administrator
 * on 2018/4/23.
 */

public class FileInfo {
    private String path;
    private String name;
    private Integer id;

    public FileInfo() {
    }

    public FileInfo(String path, String name, Integer id) {
        this.path = path;
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileInfo(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
