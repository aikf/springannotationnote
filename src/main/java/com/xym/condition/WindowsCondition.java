package com.xym.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName WindowsCondition
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 上午11:17
 * @Version 1.0
 **/
public class WindowsCondition implements Condition {

    /**
     *
     * @param context 判断条件能使用的上下文环境
     * @param metadata 注释信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1,获取到IOC使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2,获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3,获取当前环境信息
        Environment environment = context.getEnvironment();
        //4,获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        //可以判断容器中Bean的情况，也可以给容器中注册Bean
        boolean person = registry.containsBeanDefinition("person");

        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }

        return false;
    }
}