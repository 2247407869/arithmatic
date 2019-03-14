package com.example.executordemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: arithmatictest
 * @description: TODO
 * @author: LLS
 * @create: 2019-03-08 14:18
 **/
@RestController
@RequestMapping("wxTest")
public class WxTestController {

    private static final Logger logger = LoggerFactory.getLogger(WxTestController.class);

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @RequestMapping(value="helloWx")
    public ModelAndView helloWx(){
        logger.info("hello weixin!!!");
        return new ModelAndView("wx/helloWeixin");
    }


    /**
     * http://10.0.110.40:8088/wxTest/helloWxThread
     * @return
     */
    @RequestMapping(value = "helloWxThread", method = RequestMethod.GET)
    public void helloWxThread(){
        logger.info("hello weixin!!!");
        setWxTestThread();
    }


    public void setWxTestThread(){
        WxTestThread testThread = new WxTestThread();
        taskExecutor.execute(testThread);
    }
}

