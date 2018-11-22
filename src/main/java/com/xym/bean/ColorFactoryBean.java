package com.xym.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName ColorFactoryBean
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 下午1:39
 * @Version 1.0
 **/
//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject...");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }
    //是否单例
    public boolean isSingleton() {
        return true;
    }
}