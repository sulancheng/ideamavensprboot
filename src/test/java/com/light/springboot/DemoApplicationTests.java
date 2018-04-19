package com.light.springboot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ch.qos.logback.classic.Logger;

import com.light.springboot.controller.TestController;
import com.light.springboot.entity.Student;
import com.light.springboot.jpa.StudentJpa;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private StudentJpa studentJpa;
	private final static Logger logger = (Logger) LoggerFactory.getLogger(DemoApplicationTests.class);
	@Test
	public void contextLoads() {
	
	}

}
