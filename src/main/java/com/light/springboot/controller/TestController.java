package com.light.springboot.controller;

import bean.FileInfo;
import bean.Result;
import bean.StudentBean;
import bean.User;
import com.light.springboot.entity.Student;
import com.light.springboot.jpa.DbResponeBean;
import com.light.springboot.jpa.StudentJpa;
import com.light.springboot.jpa.UserServiceImpl;
import com.light.springboot.utils.HttpHelper;
import com.light.springboot.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller  //@RestController 的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
@RequestMapping("test")
public class TestController {
    @Autowired
    private StudentJpa studentJpa;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private HttpHelper myhttphelper;

    @GetMapping("")
    @ResponseBody
    public Result defaultpage(){
        List<Student> all = userServiceImpl.findAll();
        HashMap<String, List<Student>> stringListHashMap = new LinkedHashMap<>();
        for (Student student:all){
            List<Student> studentset = stringListHashMap.get(student.getMyclass());
            if (studentset==null){
                studentset = new ArrayList<>();
            }
            studentset.add(student);
            stringListHashMap.put(student.getMyclass(),studentset);
        }
        ArrayList<Object> objects = new ArrayList<>();//以班级来区分开
        for (String str:stringListHashMap.keySet()){
            StudentBean<Student> objectStudentBean = new StudentBean<Student>();
            objectStudentBean.setBanji(str);
            List<Student> students = stringListHashMap.get(str);
            objectStudentBean.setList(students);
            objects.add(objectStudentBean);
        }

        return ResultUtils.sucess("测试默认网页或者json",objects);
    }

    //    @CrossOrigin(origins="http://localhost:63343")//成功
    @RequestMapping("/hellky")
    @ResponseBody
    public String helloworld() {
        return "跨域访问";
    }

    private final static Logger logger = LoggerFactory
            .getLogger(TestController.class);

    /**
     * 可以直接返回整个html标签
     * 测试接收body里面的json数据
     *
     * @return
     */
    @RequestMapping("/helloworld")
    @ResponseBody
    public FileInfo helloworld(@RequestBody String data) {
        logger.info("json数据" + data);
//        Object parse = JSON.parse(data);
        FileInfo fileInfo = new FileInfo("dsadsad", "ssssss", 99);
        return fileInfo;
    }
    @RequestMapping("/addstu")
    @ResponseBody
    public Result addstu(@Valid Student student) throws Exception {
        return userServiceImpl.addBean(student);
    }

    //表单验证 与aop的demo   统一异常的类
    @RequestMapping("/user")
    @ResponseBody
    public Result<Object> getUser(@Valid Student studentcs, BindingResult bindingResult) {//表示要验证此参数对象,二。获取错误信息  postman用x-www发送
        if (bindingResult.hasErrors()) {
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            logger.info("表单错误信息：" + defaultMessage);//打印错误信息成功
            return ResultUtils.error(1,defaultMessage);
        }
        List<Student> findAll = studentJpa.findAll();
        // logger.info(findAll.toString());
        try {
            Optional<Student> myfnd = studentJpa.findById(19);
            Student student = myfnd.get();
            long count = studentJpa.count();
            logger.info(" student记录数量:" + count + "   student=" + student.toString());
//            List<Student> myQuery = (List<Student>) studentJpa.myQuery(999);
//            logger.info(" student记录数量自己:" + myQuery.toString());
        } catch (Exception e) {
            logger.error("取出数据异常" + e.getMessage());
        }
        return ResultUtils.sucess("sucessed",findAll);
    }

    //乐观锁的测试
    @RequestMapping("/userlg")
    @ResponseBody
    public Object getUserlg() {
        Optional<Student> byId = studentJpa.findById(19);
        Student student = byId.get();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Optional<Student> byId1 = studentJpa.findById(19);
                    Student student1 = byId1.get();
                    student1.setName("在吗");
                    student1.setAge(35);
                    studentJpa.save(student1);
                } catch (Exception e) {
                    logger.info("修改已经被人捷足先登了。抢到第一了");
                    e.printStackTrace();
                }

            }
        }).start();
        try {
            student.setAge(12);
            student.setName("我是老大");
            studentJpa.save(student);
        } catch (Exception e) {//乐观锁异常
            logger.info("修改已经被人捷足先登了。");
            return "修改失败";
        }
        return student;
    }

    @RequestMapping("/userzong")
    @ResponseBody
    public Object getUserzong(@RequestParam("susu") Integer susu) {
        logger.error("测试你妹的");
        List<Student> myQueryzong = studentJpa.myQueryzong(susu);
        if (myQueryzong.size() <= 0) {
            User user = new User();
            user.setAge("");
            user.setName("数据一条都没有了，你自己看着办");
            return user;
        }
        logger.info("userzong/ student记录数量自己:" + myQueryzong.toString());
        return myQueryzong;
    }

    /**
     * 分页和自定义查询 成功
     *
     * @param susu
     * @return
     */
    @RequestMapping("/userfy")
    @ResponseBody
    public List<Student> getUserfy(@RequestParam("susu") Integer susu) {
        PageRequest of = PageRequest.of(susu - 1, 4, new Sort(
                Sort.Direction.ASC, "id"));
//		Page<Student> findAll = studentJpa.findAll(of);
        Page<Student> findAll = studentJpa.findByName("nide", of);
        List<Student> content = findAll.getContent();
        logger.info("/userfystudent记录数量自己:" + content.toString());
//		userService.testQuery();
        return content;
    }

    /**
     * 分页和自定义查询 失败
     *
     * @param susu
     * @return
     */
    @RequestMapping("/userfyby/{susu}")
    @ResponseBody
    public List<Object> getUserfypath(@PathVariable("susu") Integer susu) {
        List<Object> findpages = userServiceImpl.findpages("student", "class", 9, 1, 5);
        logger.info("/userfystudent记录数量自己:" + findpages.toString());
        return findpages;
    }

    @RequestMapping("/deluser")
    @ResponseBody
    public String delUser(@RequestParam("susu") Integer susu) {
        int issu = studentJpa.deleteQuery(susu);
        return "删除成功" + issu;
    }

    /**
     * 测试数据库jpa的事务。
     *
     * @param id
     * @return
     */
    @RequestMapping("/upuser")
    @ResponseBody
    public Object upUser(@RequestParam("id") Integer id) throws Exception {
        return  userServiceImpl.updataById("业务逻辑到抛出异常1", id);
    }

    @RequestMapping("/map")
    @ResponseBody
    public Map getMap(HttpServletRequest request) {
        logger.info("myjson2 = " + request.getAttribute("mydata"));
//        String bodyString = myhttphelper.getBodyString(request);
//        logger.info(request.getRequestURI()+bodyString);
        Map<String, Object> myMap = new HashMap<String, Object>();
        myMap.put("one", "认识到has哦");// { "one":"认识到has哦", "name":"大傻逼" }
        myMap.put("name", "大傻逼");
        return myMap;
    }

    // 有view的
    @GetMapping("hello/{id}")//id可以是...html
    public String hello(ModelMap map,@PathVariable String id) {
        logger.info("id="+id);
        map.put("msg", "Hello Thymeleaf ModelMap");
        return "myfirst";
    }
    // 有view的
    @GetMapping("hello2")
    public ModelAndView hello2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myfirst");
        modelAndView.addObject("msg","Hello Thymeleaf ModelAndView");
        return modelAndView;
    }

    //	@RequestMapping   和  @GetMapping @PostMapping 区别
//	@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
//	@PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。
    // 有view的
    @RequestMapping("/six/{id}")
    public String six(Map<String, Object> map, @PathVariable("id") Integer idInteger) {
        map.put("hitCounter", "搞好了");
        List<Student> findAll = studentJpa.findAll();
        map.put("list", findAll);
        //map.put("id", id);
        logger.info("地址参数：" + idInteger);
        return "six";
    }

    /**
     * 使用*号
     */
    @ResponseBody
    @RequestMapping("*/xinghao")
    public String testWildcard(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        httpSession.setAttribute("存储one", "nide-one");
        logger.info("wildcard------------");
        return request.getRequestURI();
    }


    @RequestMapping("/wo")
    public String index(ModelMap model) {
        List<Student> byClass = studentJpa.findByMyclass("9");
        logger.info("取出的数据" + byClass);
        model.put("datas", byClass);
        return "index";
    }

    @RequestMapping("/zidiy") //成功
    @ResponseBody
    public Object mQuery() {
        List<DbResponeBean> dbResponeBeans = userServiceImpl.mQuerylianhcx();
        if (dbResponeBeans == null) return "我是空的";
        return dbResponeBeans;
    }

    @RequestMapping("/zidiyxz") //成功
    @ResponseBody
    public Object mQueryxz() {
        List<Student> byNameOrderByIdDesc = studentJpa.findByNameOrderByIdDesc("sdas");
        if (byNameOrderByIdDesc == null || byNameOrderByIdDesc.size() <= 0) return "我是空的";
        return byNameOrderByIdDesc;
    }

    //Session存储：可以利用HttpServletReequest的getSession()方法
    @RequestMapping("/sessiontest")
    public String sessionTest(String name, String pwd, ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("user", "我的user名字，会保留");
        request.setAttribute("onetwo", "request不会被保留");
        model.addAttribute("msg", "不会在页面之间保留");
        model.put("one", "之间");
        return "myfirst";
    }


}
