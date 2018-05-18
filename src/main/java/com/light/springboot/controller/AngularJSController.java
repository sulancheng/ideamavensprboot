package com.light.springboot.controller;

import com.light.springboot.jpa.StudentJpa;
import com.light.springboot.jpa.BeanServiceImpl;
import com.light.springboot.utils.HttpHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator
 * on 2018/5/10.
 */
@Controller
@RequestMapping("ang")
public class AngularJSController {
    public String gen = "as/";
    @Autowired
    private StudentJpa studentJpa;
    @Autowired
    private BeanServiceImpl userServiceImpl;
    @Autowired
    private HttpHelper myhttphelper;
    @RequestMapping("first")
    public String getFirstAs(){
        return gen+"firstas";
    }
    @RequestMapping("second")
    public String getsecend(ModelMap modelMap){
        modelMap.put("ab","1");
        modelMap.put("ab2","2");
        modelMap.put("ab3","3");
        modelMap.put("ab4","4");
        return gen+"second";
    }
    @RequestMapping("swipe")
    public String getSwipe(){
        return "swipedemo";
    }
    @RequestMapping("swipetwo")
    public String getSwipetwo(){
        return "swipedemotwo";
    }
}
