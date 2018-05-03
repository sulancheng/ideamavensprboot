package com.light.springboot.zhishid;

/**
 * Created by Administrator
 * on 2018/5/3.
 */
//饿汉
public class OneMyInstace {
    private OneMyInstace() {
    }
//    private static OneMyInstace oneMyInstace = new OneMyInstace();
//    private static OneMyInstace getInstance(){
//        return oneMyInstace;
//    }

    //懒汉
    private static OneMyInstace oneMyInstace;
    private static OneMyInstace getInstance() {
        if (oneMyInstace == null) {
            oneMyInstace = new OneMyInstace();
        }
        return oneMyInstace;
    }
}
