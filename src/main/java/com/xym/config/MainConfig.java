package com.xym.config;

import com.xym.bean.Person;
import com.xym.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @ClassName MainConfig
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 上午9:20
 * @Version 1.0
 **/
// 配置类==配置文件
@Configuration //告诉Spring这是一个配置类
//value:指定要扫描的包
//excludeFilters = Filter[] : 指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] : 指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION: 按照注解
//FilterType.ASSIGNABLE_TYPE: 按照给定的类型
//FilterType.ASPECTJ: 使用ASPECTJ表达式
//FilterType.REGEX: 使用正则指定
//FilterType.CUSTOM: 使用自定义规则
@ComponentScan(value = "com.xym", includeFilters = {
//    @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class,Service.class}),
//    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BookDao.class),
    @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)
},useDefaultFilters = false)
public class MainConfig {

    @Bean("person")
    public Person person(){
        return new Person("lisi", 24);
    }
}