package com.light.springboot.controller;

import bean.User;
import ch.qos.logback.classic.Logger;
import com.light.springboot.entity.Student;
import com.light.springboot.jpa.DbResponeBean;
import com.light.springboot.jpa.StudentJpa;
import com.light.springboot.jpa.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("test")
public class TestController {
	@Autowired
	private StudentJpa studentJpa;
	@Autowired
	private UserService userService;

	private final static Logger logger = (Logger) LoggerFactory
			.getLogger(TestController.class);

	/**
	 * 可以直接返回整个html标签
	 * 测试接收body里面的json数据
	 * @return
	 */
	@RequestMapping("/helloworld")
	@ResponseBody
	public String helloworld(@RequestBody String data) {
		logger.info("json数据"+data);
		return "helloworlds";
	}

	@RequestMapping("/user")
	@ResponseBody
	public List<Student> getUser() {
		User myUser = new User();
		myUser.setAge("26");
		myUser.setName("大傻逼");
		List<Student> findAll = studentJpa.findAll();
		// logger.info(findAll.toString());
		try {
			Optional<Student> myfnd = studentJpa.findById(15);
			Student student = myfnd.get();
		} catch (Exception e) {
			logger.error("取出数据异常" + e.getMessage());
		}
		long count = studentJpa.count();
		logger.info(" student记录数量:" + count);
		List<Student> myQuery = (List<Student>) studentJpa.myQuery(999);
		logger.info(" student记录数量自己:" + myQuery.toString());
		return findAll;
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
	 * 分页和自定义查询 成功
	 *
	 * @param susu
	 * @return
	 */
	@RequestMapping("/userfyby/{susu}")
	@ResponseBody
	public List<Object> getUserfypath(@PathVariable("susu") Integer susu) {
		List<Object> findpages = userService.findpages("student", "class", 9, 1, 5);

		logger.info("/userfystudent记录数量自己:" + findpages.toString());
		return findpages;
	}

	@RequestMapping("/deluser")
	@ResponseBody
	public String delUser(@RequestParam("susu") Integer susu) {
		int issu = studentJpa.deleteQuery(susu);
		return "删除成功" + issu;
	}

	@RequestMapping("/map")
	@ResponseBody
	public Map getMap() {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("one", "认识到has哦");// {"one":"认识到has哦"}
									// {"name":"大傻逼","age":"26"}
		return myMap;
	}

	// 有view的
	@GetMapping("hello")
	public String hello(Map<String, Object> map) {
		map.put("msg", "Hello Thymeleaf");
		return "myfirst";
	}

	
//	@RequestMapping   和  @GetMapping @PostMapping 区别
//	@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
//	@PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。
	// 有view的
	@RequestMapping("/six/{id}")
	public String six(Map<String, Object> map,@PathVariable("id") Integer idInteger) {
		map.put("hitCounter", "搞好了");
		List<Student> findAll = studentJpa.findAll();
		map.put("list", findAll);
		//map.put("id", id);
		logger.info("地址参数："+idInteger);
		return "six";
	}
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/zidiy")
	@ResponseBody
	public Object mQuery() {
		ArrayList<DbResponeBean> dbResponeBeans = userService.mQuerylianhcx();
		if (dbResponeBeans==null) return "我是空的";
		return dbResponeBeans;
	}
}
