package com.light.springboot;

import com.light.springboot.jpa.BeanServiceImpl;
import com.light.springboot.jpa.StudentJpa;
import com.light.springboot.utils.BytesHexStrTranslate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.Arrays;

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
//        fileinp();
//        fileout("沃日你打野丁你给");
        shujuceshi();
    }

    public void fileinp() {
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
                String str = new String(bts, 0, len);
                stringBuffer.append(str);
            }
            logger.info("读取的数据" + stringBuffer.toString());
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fileout(String data) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("D:\\springbootupload\\txt");
            if (!file.exists()) file.mkdirs();
            FileWriter fileWriter = new FileWriter(file, true);

            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data + "\r\n");
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void shujuceshi() {
        byte[] bytes = BytesHexStrTranslate.toBytes("0000000300001000800000805f9b34fb");//notify测试
        logger.debug("测试字符串转16进制字节数组"+Arrays.toString(bytes));
        byte[] bytes1 = "AT_BOND".getBytes();
        logger.debug("测试字符串转16进制字节数组2"+Arrays.toString(bytes1));
        StringBuilder shuju1 = new StringBuilder();
        for (byte data : bytes1) {
            shuju1.append((char) data);//十进制字节转化为字符
        }
        logger.debug("测试字符串转16进制字节数组3"+shuju1);

        String[] bytehex = new String[bytes1.length];
        for (int c = 0; c < bytes1.length; c++) {
            bytehex[c]=Integer.toHexString(bytes1[c]);
        }
        logger.info("测试字符串转16进制字节数组4"+Arrays.toString(bytehex));



        //16进制转十进制
        long[] byteshex = new long[bytehex.length];
        for (int c = 0; c < bytehex.length; c++){
            long dec_num = Long.parseLong(bytehex[c], 16);
            byteshex[c] = dec_num;
        }
        logger.info("测试字符串转16进制字节数组4"+Arrays.toString(byteshex));//十进制在通过(char) byteChar可以成字符。

        StringBuilder  stringBuilder4= new StringBuilder();
        for (long byteChar : byteshex)
            stringBuilder4.append((char) byteChar);
        logger.info("测试字符串转16进制字节数组5"+stringBuilder4);


        byte[] datas = {0x57, 0x58, 0x06, 0x0D, 0x0A};
        StringBuilder  stringBuilder3= new StringBuilder();
        for (byte byteChar : datas)
            stringBuilder3.append((char) byteChar);
        logger.info("测试字符串转16进制字节数组6"+stringBuilder3);


//        String strHex2 = String.format("%08x", valueTen);
//        byte[] datas = {0xFD, 0xFD, 0x06, 0x0D, 0x0A};
//        byte[] mydatas = new byte[]{0x00, 0x00};
//        StringBuilder stringBuilder = new StringBuilder();
//        StringBuilder stringBuilder2 = new StringBuilder();
//        for (byte data : datas) {
//
//            stringBuilder.append((char) data);
//        }
//        for (byte data : datas) {
//            stringBuilder2.append(String.format("%02X ", data));
//        }

    }
}
