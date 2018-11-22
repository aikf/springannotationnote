package com.xym.config;

import com.xym.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName MainConfigOfPropertyValues
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 下午4:10
 * @Version 1.0
 **/
//读取外部配置文件中的K/V保存到运行环境变量中，加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource({"classpath:person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }
}