package com.example.executordemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: arithmatictest
 * @description: TODO
 * @author: LLS
 * @create: 2019-03-08 14:17
 **/
public class WxTestThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(WxTestThread.class);
    @Override
    public void run() {
        logger.info("执行线程！");
    }
}
