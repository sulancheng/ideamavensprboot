package com.light.springboot.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sucheng
 * on 2018/4/27.
 */
public class JavaLocalUtils {
    public static List<File> fileList = new ArrayList<File>();
    public static List<File> forDir(File f) {
        if (f == null) return null;
        File[] files = f.listFiles();
        if (files == null) return null;
        //先删文件,后删目录
        for (File file : files) {
            if (file.isFile()) {
                fileList.add(file);
            }else if (file.isDirectory()){
                forDir(file);
            }
        }
        return fileList;
    }
}
