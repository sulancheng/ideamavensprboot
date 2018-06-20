package com.light.springboot.controller;

import bean.Result;
import bean.StudentBean;
import com.light.springboot.entity.Student;
import com.light.springboot.jpa.BeanServiceImpl;
import com.light.springboot.jpa.StudentJpa;
import com.light.springboot.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by sucheng
 * on 2018/5/5.
 */
@Controller  //@RestController 的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
@RequestMapping()
public class DefaultController {
    @Autowired
    private StudentJpa studentJpa;
    @Autowired
    private BeanServiceImpl userServiceImpl;
    @GetMapping("")
    @ResponseBody
    public Result defaultpage(){
        List<Student> all = userServiceImpl.findAll();
        HashMap<String, List<Student>> stringListHashMap = new LinkedHashMap<>();
        for (Student student : all) {
            List<Student> studentset = stringListHashMap.get(student.getMyclass());
            if (studentset == null) {
                studentset = new ArrayList<>();
            }
            studentset.add(student);
            stringListHashMap.put(student.getMyclass(), studentset);
        }
        ArrayList<Object> objects = new ArrayList<>();//以班级来区分开
        for (String str : stringListHashMap.keySet()) {
            StudentBean<Student> objectStudentBean = new StudentBean<Student>();
            objectStudentBean.setBanji(str);
            List<Student> students = stringListHashMap.get(str);
            objectStudentBean.setList(students);
            objects.add(objectStudentBean);
        }

        //此种比较简便  不用new 对象
        ArrayList<Object> objectstwo = new ArrayList<>();//以班级来区分开
        for (String str : stringListHashMap.keySet()) {
            ModelMap modelMap = new ModelMap();
            List<Student> students = stringListHashMap.get(str);
            modelMap.put("banjitwo", str);
            modelMap.put("listtwo", students);
            objectstwo.add(modelMap);
        }

        return ResultUtils.sucess("测试默认网页或者jsonnimeide76868", objectstwo);
    }
//    @GetMapping("socket")
//    @ResponseBody
//    public void connsocket(){
//        SocketServer.startService();
//    }
}
