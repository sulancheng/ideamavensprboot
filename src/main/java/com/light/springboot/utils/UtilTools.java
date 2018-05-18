package com.light.springboot.utils;

import com.light.springboot.entity.Ticket;
import com.light.springboot.jpa.TicketServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator
 * on 2018/5/3.
 */
@Component
public class UtilTools {
    @Autowired
    TicketServiceImpl ticketService;
    private final static Logger logger = LoggerFactory.getLogger(UtilTools.class);
    public  boolean isAjax(HttpServletRequest request){
        boolean isAjaxRequest = false;
        if(!isBlank(request.getHeader("x-requested-with")) && request.getHeader("x-requested-with").equals("XMLHttpRequest")){
            isAjaxRequest = true;
        }
        return isAjaxRequest;
    }
    public  boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }


    public  String getFileName(String pathandname) {
        /**
         * 仅保留文件名不保留后缀
         */
        int start = pathandname.lastIndexOf("/");
        int end = pathandname.lastIndexOf(".");
        if (start != -1 && end != -1) {
            return pathandname.substring(start + 1, end);
        } else {
            return null;
        }
    }
    /**
     * 保留文件名及后缀
     */
    public  String getFileNameWithSuffix(String pathandname) {
        int start = pathandname.lastIndexOf("/");
        if (start != -1 ) {
            return pathandname.substring(start + 1);
        } else {
            return null;
        }
    }
    /**
     * 保留文件名及后缀
     */
    public  String getFileNameWithSuffixtwo(String pathandname) {
        int start = pathandname.lastIndexOf("\\");
        if (start != -1 ) {
            return pathandname.substring(start + 1);
        } else {
            return null;
        }
    }

    public  String getFileNameWithdian(String pathandname) {
        int start = pathandname.lastIndexOf(".");
        if (start != -1 ) {
            return pathandname.substring(0,start);
        } else {
            return null;
        }
    }
    public synchronized void sell() {

        Ticket ticket = ticketService.findAll().get(0);
        Integer tkcountone = ticket.getTkcount();
        while (tkcountone > 0) {
            logger.info("线程:"+Thread.currentThread().getName() + "正在卖第" + tkcountone + "张票");
            tkcountone--;
            ticket.setTkcount(tkcountone);
            if (tkcountone<0) tkcountone=0;
            ticketService.saveOne(ticket);
        }
    }
}
