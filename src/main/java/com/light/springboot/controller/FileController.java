package com.light.springboot.controller;

import bean.FileInfo;
import ch.qos.logback.classic.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * upload文件and下载文件
 * Created by Administrator
 * on 2018/4/23.
 */
@Controller
@RequestMapping("/file")
public class FileController {
    private final String path = "d:\\springbootupload\\imgs";
    private final static Logger logger = (Logger) LoggerFactory
            .getLogger(FileController.class);

    @PostMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file) throws Exception {
        logger.info("是空的吗？" + (file == null));
        File localFile = null;
        File localFiletwo = null;
        if (!file.isEmpty()) {
            File pathfile = new File(path);
            if (!pathfile.exists()) {
                pathfile.mkdirs();
            }
            localFile = new File(pathfile, file.getOriginalFilename());
            //获取跟目录
            File path = new File(ResourceUtils.getURL("src/main/resources/static/imgs").getPath());//成功
            if (!path.exists()) {
                path.mkdirs();
            }
            logger.info("动态获取classpath:" + path.getAbsolutePath());
            localFiletwo = new File(path, file.getOriginalFilename());
//            file.transferTo(localFile);
            file.transferTo(localFiletwo);
//           成功
//            localFiletwo = new File("D:\\githubworksp\\ideapringb\\src\\main\\resources\\static\\imgs", file.getOriginalFilename());
        } else {
            return "文件是空的！";
        }
        return new FileInfo(localFile.getAbsolutePath());
    }

    @RequestMapping("/uploadImgs")
    @ResponseBody
    public void uploadImg(MultipartFile file[], String areaName) throws Exception {
        logger.info("是空的吗？" + (file == null));
        File localFiletwo = null;
        for (MultipartFile f : file) {
            // 图片的名字用毫秒数+图片原来的名字拼接
//            System.out.println(f.getSize());
//            System.out.println(f.getBytes());
            String imgName = System.currentTimeMillis() + f.getOriginalFilename();
            if (!f.isEmpty()) {
                //获取跟目录
                File path = new File(ResourceUtils.getURL("src/main/resources/static/imgs").getPath());//成功
                if (!path.exists()) {
                    path.mkdirs();
                }
                logger.info("动态获取classpath:" + imgName);
                localFiletwo = new File(path, imgName);
                f.transferTo(localFiletwo);
//           成功
//           localFiletwo = new File("D:\\githubworksp\\ideapringb\\src\\main\\resources\\static\\imgs", file.getOriginalFilename());
            }
        }
    }

    @RequestMapping("/imgs/{id}")//这种方式可以将数据存到硬盘
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(path, id + ".jpg")));
            ServletOutputStream outputStream = response.getOutputStream();
            OutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + id + ".jpg");
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
