package com.light.springboot;

import com.light.springboot.jpa.StudentJpa;
import com.light.springboot.jpa.BeanServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

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
    private BeanServiceImpl userServiceImpl;
    private final static Logger logger = LoggerFactory.getLogger(StudentTest.class);
    @Test
    public void testmyinquery() {
//        List<DbResponeBean> dbResponeBeans = userServiceImpl.mQuerylianhcx();
//        logger.info("自己定义的数据测试service="+dbResponeBeans.toString());
        fileinp();
        fileout("沃日你打野丁你给");
    }
    public void fileinp(){
        //读取  BufferedInputStream
        BufferedReader bufferedReader = null;
        try {
//            FileInputStream fileInputStream = new FileInputStream("e://test.txt");
//            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream,"GB2312"));
            bufferedReader = new BufferedReader(new FileReader("e://test.txt"));
            //一次读取一个字节数组
//            byte[] bts = new byte[1024];
            char[] bts = new char[1024];
            StringBuffer stringBuffer = new StringBuffer();
            int len;
            while ((len = bufferedReader.read(bts)) != -1) {
                String str = new String(bts,0,len);
                stringBuffer.append(str);
            }
            logger.info("读取的数据"+stringBuffer.toString());
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fileout(String data){
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("D:\\springbootupload\\txt");
            if (!file.exists()) file.mkdirs();
            FileWriter fileWriter = new FileWriter(file, true);

            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data+"\r\n");
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter!=null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
