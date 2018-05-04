package com.light.springboot;


import com.light.springboot.jpa.StudentJpa;
import com.light.springboot.utils.JavaLocalUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private StudentJpa studentJpa;
	private final static Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);
	@Test
	public void contextLoads() {
		getPreviousMonthEnd();
	}
	@Test
	public void testjava() {
		JavaLocalUtils.fileList.clear();
		List<File> files = JavaLocalUtils.forDir(new File("G:\\电影电视剧"));
		for (File f1 : files) {
			logger.info("搜索的文件名字："+f1.getAbsolutePath()+"  名字"+f1.getName());
		}
		JavaLocalUtils.fileList.clear();
	}
	public String getPreviousMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Calendar lastDate = Calendar.getInstance();
		logger.info("装换之前"+sdf.format(lastDate.getTime()));
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		str = sdf.format(lastDate.getTime());
		logger.info("装换之后"+str);
		return str;
	}

}
