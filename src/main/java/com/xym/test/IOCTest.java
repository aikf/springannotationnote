package com.xym.test;

import com.xym.bean.Boss;
import com.xym.bean.Car;
import com.xym.bean.Color;
import com.xym.bean.Person;
import com.xym.config.*;
import com.xym.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @ClassName IOCTest
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 上午9:37
 * @Version 1.0
 **/
public class IOCTest {
    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

    private void printBeanNames() {
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
    @Test
    public void test1(){
        printBeanNames();
    }

    @Test
    public void test2(){
        printBeanNames();
        System.out.println("IOC容器创建完成");
//        Object person = context.getBean("person");
//        Object person2 = context.getBean("person");
//        System.out.println(person==person2);
    }

    @Test
    public void test3(){
        String[] names = context.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        //获取环境变量的值：Mac OS X
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : names) {
            System.out.println(name);
        }

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    public void testImport(){
        printBeanNames();
        Object colorFactoryBean = context.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean.getClass().getName());
    }

    @Test
    public void testPropertyValue(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        Person person = (Person) context.getBean("person");
        System.out.println(person);
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
    }
    
    @Test
    public void testAutowired() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
//        BookService bookService = context.getBean(BookService.class);
//        System.out.println(bookService);
        Boss boss = context.getBean(Boss.class);
        Car car = context.getBean(Car.class);
        System.out.println(car);
        System.out.println(boss);

        Color color = context.getBean(Color.class);
        System.out.println(color);
    }

    /**
     * 1. 使用命令行动态参数：在虚拟机参数位置加载-Dspring.profiles.active=test
     * 2. 使用代码的方式实现
     */
    @Test
    public void testProfile(){
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        // 1. 创建无参context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 2. 设置需要激活的环境
        context.getEnvironment().setActiveProfiles("test", "dev");
        // 3. 注册主配置类
        context.register(MainConfigOfProfile.class);
        // 4. 启动刷新容器
        context.refresh();

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}