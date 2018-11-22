package com.xym;

import com.xym.bean.Person;
import com.xym.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName MainTest
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 上午9:17
 * @Version 1.0
 **/
public class MainTest {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//        Person person = (Person) context.getBean("person");
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String bean : beanNamesForType) {
            System.out.println(bean);
        }
//        System.out.println(person);
    }
}