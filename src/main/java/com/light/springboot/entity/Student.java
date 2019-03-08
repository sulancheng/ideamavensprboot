package com.light.springboot.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = -6826119197709479975L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)//主键
//    @NotNull(message = "id不能为空")
    private Integer id;
    @NotBlank(message = "姓名不能为空")
    @Column(name = "name")
    private String name;
    @NotNull(message = "班级不能为空")
    @Column(name = "tfclass")
    private String myclass;

    @Min(value = 8, message = "此人太小了!")
    @Column(name = "age")
    @NotNull
    private Integer age;

    @Column(name = "start_time")
    @NotNull(message = "时间不能为空")
    private Date starttime;

    @Transient
    private String starttimes;

    public String getStarttimes() {
        return starttimes;
    }

    public void setStarttimes(String starttimes) {
        this.starttimes = starttimes;
    }

    @Version
    private int version;

    @Transient
    private Integer sumid;

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Integer getSumid() {
        return sumid;
    }


    public void setSumid(Integer sumid) {
        this.sumid = sumid;
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


    public String getMyclass() {
        return myclass;
    }


    public void setMyclass(String myclass) {
        this.myclass = myclass;
    }


    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", myclass='" + myclass + '\'' +
                ", age=" + age +
                ", starttime=" + starttime +
                ", starttimes='" + starttimes + '\'' +
                ", version=" + version +
                ", sumid=" + sumid +
                '}';
    }
}
