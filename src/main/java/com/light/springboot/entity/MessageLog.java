package com.light.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator
 * on 2019/1/17 0017.
 */
@Entity
@Table(name = "t_message_log")
public class MessageLog implements Serializable {
    private static final long serialVersionUID = -402109639795277713L;
    @Id
    @Column(name = "message_id")
    @GeneratedValue//主键
    private String messageid;

    @Column(name = "message")
    private String message;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
