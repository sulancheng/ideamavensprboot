package com.light.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator
 * on 2019/1/17 0017.
 */
@Entity
@Table(name = "t_order")
public class Order implements Serializable {
    private static final long serialVersionUID = -7803186291201311181L;
    @Id
    @Column(name = "id")
    @GeneratedValue//主键
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "message_id")
    private String messageId;


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

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", messageId='" + messageId + '\'' +
                '}';
    }
}
