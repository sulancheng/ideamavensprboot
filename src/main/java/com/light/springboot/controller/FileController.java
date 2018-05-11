package com.light.springboot.controller;

import bean.FileInfo;
import com.light.springboot.exception.MyException;
import com.light.springboot.utils.JavaLocalUtils;
import com.light.springboot.utils.ResultUtils;
import com.light.springboot.utils.UtilTools;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * upload文件and下载文件
 * Created by Administrator
 * on 2018/4/23.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private final String path = "d:\\springbootupload\\img";
    private final static Logger logger = LoggerFactory
            .getLogger(FileController.class);

    @RequestMapping("/zjplay")
    public ModelAndView rejPlay(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("datas", "1");
        modelAndView.addObject("id", "1");
        modelAndView.addObject("name", "1");
        modelAndView.addObject("playingpath", "/moves/五十度黑未分级版.720p.BD中英双字[www.66ys.tv].mp4");
        modelAndView.setViewName("play");
        return modelAndView;
    }


    //搜索目标文件夹的所有的文件
    @RequestMapping("/getmove")
    public Object getMove(HttpServletRequest request, ModelMap model) throws FileNotFoundException {
        JavaLocalUtils.fileList.clear();
        //获取跟目录
        File path = new File(ResourceUtils.getURL("src/main/resources/static/moves").getPath());
//        File path = new File("D:\\网易云音乐");//相对地址
//        File path = new File(ResourceUtils.getURL("target/springboot-0.0.1/WEB-INF/classes/static/moves").getPath());//绝对地址
        //注意  所有的相对地址，在tomcat中失效。 要用绝对地址
//        URL resource = this.getClass().getResource("/");
//        logger.info("地址是1resource："+resource.getPath());
//        logger.info("地址是2path："+path.getPath());
//        logger.info("地址是2 path1："+path1.getPath());
//        List<File> files = JavaLocalUtils.delDir(new File("D:\\网易云音乐"));
        List<File> files = JavaLocalUtils.forDir(path);
        if (files == null || files.size() <= 0) {
            throw new MyException(path.getAbsolutePath() + "文件夹无数据无数据", 3);
        }
        List<FileInfo> fileInfos = new ArrayList<>();
//        for (File f1 : files) {
//            logger.info("搜索的文件名字：" + f1.getAbsolutePath() + "  名字" + f1.getName());
//        }
        request.getSession().setAttribute("mypc_moves", files);
        for (int x = 0; x < files.size(); x++) {
            fileInfos.add(new FileInfo(files.get(x).getAbsolutePath(), files.get(x).getName(), x));
        }
        model.put("datas", fileInfos);
        return "indexmy";
    }

    //播放目标文件夹的所有的文件
    @RequestMapping("/player/{id}/{name}")
    @ResponseBody
    public Object startMove(HttpServletRequest request, @PathVariable int id, @PathVariable String name) {
        List<FileInfo> fileInfos = new ArrayList<>();
        List<File> files = (List<File>) request.getSession().getAttribute("mypc_moves");
        File playing = files.get(id);
        String absolutePath = playing.getAbsolutePath();
        logger.info("正需要播放的地址：" + absolutePath);
        if (files != null && files.size() > 0) {
            for (int x = 0; x < files.size(); x++) {
                String fileNameWithSuffix = "/moves/" + UtilTools.getFileNameWithSuffixtwo(files.get(x).getAbsolutePath());
                fileInfos.add(new FileInfo(fileNameWithSuffix, files.get(x).getName(), x));
            }
        }
        if (name.contains("web") && !UtilTools.isAjax(request)) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("datas", fileInfos);
            modelAndView.addObject("id", id);
            modelAndView.addObject("name", name);
            String fileNameWithSuffix = UtilTools.getFileNameWithSuffixtwo(absolutePath);
            modelAndView.addObject("playingpath", "/moves/" + fileNameWithSuffix);
            modelAndView.setViewName("play");
            return modelAndView;
        }
        return  ResultUtils.sucess("sucess", fileInfos.get(id));
    }


    //播放目标文件夹的所有的文件
    @RequestMapping("/startmove/{moveid}")
    public String startMove(HttpServletRequest request, HttpServletResponse response, @PathVariable int moveid) {
//        logger.info("收到的moveid:" + moveid);
        List<File> files = (List<File>) request.getSession().getAttribute("mypc_moves");
        if (files == null || files.size() <= 0) {
            return "throwerro";
        }
        File file = files.get(moveid);
        logger.warn("正在播放的moveid:" + file.getName() + "  地址：" + file.getName());
//        File file = new File("G:\\电影电视剧\\个人\\玉生烟 练习室版--音悦Tai.mp4");
        InputStream inputStream = null;
        OutputStream bufferedOutputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
            ServletOutputStream outputStream = response.getOutputStream();
            bufferedOutputStream = new BufferedOutputStream(outputStream);
//            response.setContentType("application/x-download");
            IOUtils.copyLarge(inputStream, bufferedOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("正在播放的moveid:已经停止播放");
        }
        return null;
    }


    @PostMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file, @RequestParam String name) throws Exception {//成功
        logger.info("是空的吗？" + (file == null) + "   name=" + name);
        File localFile = null;
        File localFiletwo = null;
        if (!file.isEmpty()) {
            File pathfile = new File(path);
            if (!pathfile.exists()) {
                pathfile.mkdirs();
            }
            localFile = new File(pathfile, file.getOriginalFilename());
            //获取跟目录
            File path = new File(ResourceUtils.getURL("src/main/resources/static/img").getPath());//成功
            if (!path.exists()) {
                path.mkdirs();
            }
            String originalFilename = file.getOriginalFilename();
            String prefix = originalFilename.substring(originalFilename.lastIndexOf("."));//如果想获得不带点的后缀，变为fileName.lastIndexOf(".")+1
            logger.info("动态获取classpath:" + path.getAbsolutePath());
//            localFiletwo = new File(path, file.getOriginalFilename());
            localFiletwo = new File(path, String.valueOf(new Date().getTime()) + prefix);
//            file.transferTo(localFile);
            file.transferTo(localFiletwo);
//           成功
//            localFiletwo = new File("D:\\githubworksp\\ideapringb\\src\\main\\resources\\static\\img", file.getOriginalFilename());
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
                File path = new File(ResourceUtils.getURL("src/main/resources/static/img").getPath());//成功
                if (!path.exists()) {
                    path.mkdirs();
                }
                logger.info("动态获取classpath:" + imgName);
                localFiletwo = new File(path, imgName);
                f.transferTo(localFiletwo);
//           成功
//           localFiletwo = new File("D:\\githubworksp\\ideapringb\\src\\main\\resources\\static\\img", file.getOriginalFilename());
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
