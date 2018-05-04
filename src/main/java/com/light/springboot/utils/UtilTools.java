package com.light.springboot.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator
 * on 2018/5/3.
 */

public class UtilTools {
    public static boolean isAjax(HttpServletRequest request){
        boolean isAjaxRequest = false;
        if(!isBlank(request.getHeader("x-requested-with")) && request.getHeader("x-requested-with").equals("XMLHttpRequest")){
            isAjaxRequest = true;
        }
        return isAjaxRequest;
    }
    public static boolean isBlank(final CharSequence cs) {
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


    public static String getFileName(String pathandname) {
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
    public static String getFileNameWithSuffix(String pathandname) {
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
    public static String getFileNameWithSuffixtwo(String pathandname) {
        int start = pathandname.lastIndexOf("\\");
        if (start != -1 ) {
            return pathandname.substring(start + 1);
        } else {
            return null;
        }
    }
}
