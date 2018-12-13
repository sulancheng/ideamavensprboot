package com.light.springboot.controller;

import bean.FileInfo;
import bean.Result;
import bean.User;
import com.light.springboot.entity.Student;
import com.light.springboot.enums.ResultEnum;
import com.light.springboot.exception.MyException;
import com.light.springboot.jpa.BeanServiceImpl;
import com.light.springboot.jpa.DbResponeBean;
import com.light.springboot.jpa.StudentJpa;
import com.light.springboot.jpa.TicketServiceImpl;
import com.light.springboot.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Api(value = "所有的test测试", tags = { "多种接收前面传过来的数据" })
@Controller  //@RestController 的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
@RequestMapping("test")
public class TestController {
    @Autowired
    private StudentJpa studentJpa;
    @Autowired
    private BeanServiceImpl userServiceImpl;
    @Autowired
    private TicketServiceImpl ticketService;
    @Autowired
    private HttpHelper myhttphelper;
    @Autowired
    private HttpRequestor httpRequestor;

    @ApiOperation(value = "设定的默认的json数据回复", notes = "默认json")
//    @ApiImplicitParam(name = "susu", value = "后面的页数", required = true, dataType = "String")
    @GetMapping("")
    @ResponseBody
    public Result defaultpage() {
        byte[] data = "AT+BOND".getBytes();
        byte[] data2 = "at+bond".getBytes();
        StringBuilder stringBuilder = null;
        if (data != null && data.length > 0) {
            stringBuilder = new StringBuilder(data.length);
            for (byte byteChar : data) {
                stringBuilder.append(byteChar);
                stringBuilder.append(",");
            }
        }
        StringBuilder stringBuilder2 = null;
        if (data2 != null && data2.length > 0) {
            stringBuilder2 = new StringBuilder(data2.length);
            for (byte byteChar : data2) {
                stringBuilder2.append(byteChar);
                stringBuilder2.append(",");
            }
        }
        String s = bytesToHexFun1(data);
        logger.info("stringBuilder = "+stringBuilder+"      stringBuilder2 = "+stringBuilder2);
        logger.info( " 16进制："+s);
        return ResultUtils.sucess("测试默认网页或者json", null);
    }
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /**
     * 方法一：
     * byte[] to hex string
     *
     * @param bytes
     * @return
     */
    public static String bytesToHexFun1(byte[] bytes) {
        // 一个byte为8位，可用两个十六进制位标识
        char[] buf = new char[bytes.length * 2];
        int a = 0;
        int index = 0;
        for(byte b : bytes) { // 使用除与取余进行转换
            if(b < 0) {
                a = 256 + b;
            } else {
                a = b;
            }

            buf[index++] = HEX_CHAR[a / 16];
            buf[index++] = HEX_CHAR[a % 16];
        }

        return new String(buf);
    }

    //    @CrossOrigin(origins="http://localhost:63343")//成功
    @ApiOperation(value = "ajax跨域的测试", notes = "ajax跨域的测试")
    @RequestMapping(value = "/hellky",method = RequestMethod.GET)
    @ResponseBody
    public String helloworld() {
        return "跨域访问";
    }

    private final static Logger logger = LoggerFactory
            .getLogger(TestController.class);



    @ApiOperation(value = "无聊写的测试", notes = "无聊写的测试html")
    @ApiImplicitParam(name = "data", value = "发送的json字符串", required = true, dataType = "String")
    @GetMapping("/test01")
    public Object test01() throws Exception {
        return "1206test1";
    }



    /**
     * 可以直接返回整个html标签
     * 测试接收body里面的json数据
     *
     * @return
     */
    @ApiOperation(value = "测试接收前端发来的json字符串", notes = "测试接收前端发来的json字符串成功")
    @ApiImplicitParam(name = "data", value = "发送的json字符串", required = true, dataType = "String")
    @PostMapping("/helloworld")
    @ResponseBody
    public Object get(@RequestBody String data) throws Exception {
//        Object parse = JSON.parse(data);
//        String s = httpRequestor.doGet("http://127.0.0.1:8081/test/map");
        logger.info("json数据" + data);
        FileInfo fileInfo = new FileInfo(data, "ssssss", 99);
        return ResultUtils.sucess("成功", "返回:" + data);
    }
    @ApiOperation(value = "添加对象", notes = "添加对象")
    @ApiImplicitParam(name = "student", value = "添加多个关于student中变量的参数", required = true, dataType = "Student")
    @RequestMapping(value="/addstu", method=RequestMethod.POST)
    @ResponseBody
    public Result addstu(@RequestBody Student student) throws Exception {
        return userServiceImpl.addBean(student);
    }

    //表单验证 与aop的demo   统一异常的类
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> getUser(@Valid Student studentcs, BindingResult bindingResult) {//表示要验证此参数对象,二。获取错误信息  postman用x-www发送
        if (bindingResult.hasErrors()) {
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            logger.info("表单错误信息：" + defaultMessage);//打印错误信息成功
            return ResultUtils.error(ResultEnum.ERROR.getCode(), defaultMessage);
        }
        List<Student> findAll = studentJpa.findAll();
        // logger.info(findAll.toString());
//        Optional<Student> myfnd = studentJpa.findById(19);
//        Student student = myfnd.get();
        if (findAll == null || findAll.size() <= 0) {
            throw new MyException(ResultEnum.NULLDATA);
        }
        long count = studentJpa.count();
        return ResultUtils.sucess("sucessed", findAll);
    }

    //乐观锁的测试
    @GetMapping("/userlg")
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
//request.getParameter()取得是通过容器的实现来取得通过类似post，get等方式传入的数据，，  request.setAttribute()和getAttribute()只是在web容器内部流转，仅仅是请求处理阶段，这个的确是正解.
    @PostMapping("/userzong")
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
    @ApiOperation(value = "页面表格", notes = "换页面")
//    @ApiImplicitParam(name = "susu", value = "后面的页数", required = true, dataType = "String")
    @RequestMapping(value = "/userfy/{susu}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserfy(@PathVariable("susu") String susu, HttpServletRequest request) {
        String fileNameWithdian = utilTools.getFileNameWithdian(susu);
        logger.info("susu=" + susu + "   fileNameWithdian=" + fileNameWithdian);
        int size = 4;
        PageRequest of = PageRequest.of(Integer.valueOf(fileNameWithdian) - 1, size, new Sort(
                Sort.Direction.ASC, "id"));
        Page<Student> findAll = studentJpa.findAll(of);
//        Page<Student> findAll = studentJpa.findByName("nide", of);
        List<Student> content = findAll.getContent();

//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            public void run() {
//                logger.error("split后数据的长度调度了");
//            }
//        }, 2000,1000 );
        logger.info("/getUserfy:" + content.toString());
        Map modelMap = new HashMap<>();
        modelMap.put("one", "你好");
        modelMap.put("two", "你好2");
        modelMap.put("list", content);
        String[] strings = studentJpa.selectName();
        for (String str : strings) {
            logger.info("/getUserfy:" + str);
        }
        if (!utilTools.isAjax(request)) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("list", content);
            modelAndView.addObject("page_total", studentJpa.findAll().size());
            modelAndView.addObject("currenpage", Integer.valueOf(fileNameWithdian));
            modelAndView.addObject("size", size);
            modelAndView.setViewName("pagin");
            return modelAndView;
        }
        return ResultUtils.sucess("成功", modelMap);
    }

    /**
     * 分页和自定义查询 失败
     *
     * @param susu
     * @return
     */
    @ApiOperation(value = "分页和自定义查询 失败", notes = "分页和自定义查询 失败")
    @GetMapping("/userfyby/{susu}")
    public List<Object> getUserfypath(@PathVariable("susu") Integer susu) {
        List<Object> findpages = userServiceImpl.findpages("student", "class", 9, 1, 5);
        logger.info("/userfystudent记录数量自己:" + findpages.toString());
        return findpages;
    }

    @GetMapping("/deluser")
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
    @ApiOperation(value = "测试数据库jpa的事务", notes = "测试数据库jpa的事务")
    @PostMapping("/upuser")
    @ResponseBody
    public Object upUser(@RequestParam("id") Integer id) throws Exception {
        return userServiceImpl.updataById("业务逻辑到抛出异常1", id);
    }

    @GetMapping("/map")
    @ResponseBody
    public Result getMap(HttpServletRequest request) {
        logger.info("myjson2 = " + request.getAttribute("mydata"));
//        String bodyString = myhttphelper.getBodyString(request);
        Map<String, Object> myMap = new HashMap<String, Object>();
        myMap.put("one", "认识到has哦");// { "one":"认识到has哦", "name":"大傻逼" }
        myMap.put("name", "大傻逼");
        return ResultUtils.sucess("成功", myMap);
    }

    // 有view的
    @GetMapping("hello/{id}")//id可以是...html
    public String hello(ModelMap map, @PathVariable String id) {
        logger.info("id=" + id);
        map.put("msg", "Hello Thymeleaf ModelMap");
        return "test/myfirst";
    }

    // 有view的
    @GetMapping("hello2")
    public ModelAndView hello2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myfirst");
        modelAndView.addObject("msg", "Hello Thymeleaf ModelAndView");
        return modelAndView;
    }

    @GetMapping("shuaxcss")
    public String f5css() {
        return "shuax";
    }

    //	@RequestMapping   和  @GetMapping @PostMapping 区别
//	@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
//	@PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。
    // 有view的
    @GetMapping("/six/{id}")
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
    @PostMapping("*/xinghao")
    public String testWildcard(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        Cookie where = CookieUtil.get(request, "where");
        if (where != null && where.getValue() != null) {
            logger.info("wildcard------------1111" + where.getValue());
        }
        CookieUtil.set(response, "where", request.getRequestURL().toString(), 7200);
        response.addCookie(new Cookie("where", request.getRequestURL().toString()));
        logger.info("wildcard------------222" + httpSession.getAttribute("one"));
        httpSession.setAttribute("one", "nide-one");
        logger.info("wildcard------------333");
        return request.getRequestURI();
    }

    @Autowired
    UtilTools utilTools;

    @GetMapping("/wo")
    @ResponseBody
    public Object index(HttpServletResponse response) {
        //清除cookie
        CookieUtil.set(response, "where", null, 0);
//        List<Student> byClass = studentJpa.findByMyclass("9");
//        logger.info("取出的数据" + byClass);
//        model.put("data-toggle", byClass);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                utilTools.sell();
//            }
//        }).start();
//        utilTools.sell();
        return "nimei";
    }
    @ApiOperation(value = "自定义联合查询的调用", notes = "自定义联合查询的调用")
    @GetMapping("/zidiy") //成功
    @ResponseBody
    public Object mQuery() {
        List<DbResponeBean> dbResponeBeans = userServiceImpl.mQuerylianhcx();
        if (dbResponeBeans == null) return "我是空的";
        return dbResponeBeans;
    }
    @ApiOperation(value = "自定义dao层方法", notes = "自定义dao层方法")
    @GetMapping("/zidiyxz") //成功
    @ResponseBody
    public Object mQueryxz() {
        List<Student> byNameOrderByIdDesc = studentJpa.findByNameOrderByIdDesc("sdas");
        if (byNameOrderByIdDesc == null || byNameOrderByIdDesc.size() <= 0) return "我是空的";
        return byNameOrderByIdDesc;
    }

    //Session存储：可以利用HttpServletReequest的getSession()方法
    @ApiOperation(value = "测试session的作用域", notes = "测试session的作用域")
    @PostMapping("/sessiontest")
    public String sessionTest(String name, String pwd, ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("user", "我的user名字，会保留");
        request.setAttribute("onetwo", "request不会被保留");
        model.addAttribute("msg", "不会在页面之间保留");
        model.put("one", "之间");
        return "myfirst";
    }


}
