package com.light.springboot;

import ch.qos.logback.classic.Logger;
import com.light.springboot.jpa.DbResponeBean;
import com.light.springboot.jpa.StudentJpa;
import com.light.springboot.jpa.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/4/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentJpa studentJpa;
    @Autowired
    private UserServiceImpl userServiceImpl;
    private final static Logger logger = (Logger) LoggerFactory.getLogger(StudentTest.class);
    @Test
    public void testmyinquery() {
        List<DbResponeBean> dbResponeBeans = userServiceImpl.mQuerylianhcx();
        logger.info("自己定义的数据测试service="+dbResponeBeans.toString());
    }
}
