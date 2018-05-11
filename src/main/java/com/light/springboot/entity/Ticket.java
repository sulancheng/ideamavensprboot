package com.light.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator
 * on 2018/5/11.
 */
@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1695121250406867183L;
    @Id
    @Column(name = "id")
    @GeneratedValue//主键
    private Integer id;

    @Column(name = "tk_count")
    private Integer tkcount;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTkcount() {
        return tkcount;
    }

    public void setTkcount(Integer tkcount) {
        this.tkcount = tkcount;
    }

}
