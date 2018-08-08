package com.light.springboot.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator
 * on 2018/7/4.
 */
@Component
public class QuartzService {

    @Scheduled(fixedRate = 700000)
    public void timerToNow(){
        /*思想：对于邮箱验证过期，在生成一个识别码的时候生成当时的时间存储在数据库，这里循环执行，当前时间与存储时间
        * 的时间差大于某个值的时候可以产出识别码 也就是失效*/
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
