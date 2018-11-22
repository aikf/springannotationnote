package com.xym.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 下午2:24
 * @Version 1.0
 **/
@Component
public class Cat implements InitializingBean,DisposableBean {
    public Cat(){
        System.out.println("cat constructor...");
    }

    public void destroy() throws Exception {
        System.out.println("cat destroy...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("cat init...");
    }
}