package com.xym.bean;

import org.springframework.stereotype.Component;

/**
 * @ClassName Car
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 下午2:03
 * @Version 1.0
 **/

@Component
public class Car {
    public Car(){
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car init...");
    }

    public void destroy(){
        System.out.println("car destroy...");
    }

}