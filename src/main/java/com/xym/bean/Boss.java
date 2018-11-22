package com.xym.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName Boss
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 下午5:38
 * @Version 1.0
 **/

//默认加在IOC容器的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
@Component
public class Boss {
    private Car car;

    //构造器要用的组件都是从容器中获取
//    @Autowired
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss...有参构造");
    }

//    public Boss() {
//    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }

    public Car getCar() {
        return car;
    }

//    @Autowired
    //标注在方法 Spring容器创建当前对象，就会调用方法完成赋值
    //方法使用的参数，自定义类型的值从IOC容器中获取
    public void setCar(Car car) {
        this.car = car;
    }
}