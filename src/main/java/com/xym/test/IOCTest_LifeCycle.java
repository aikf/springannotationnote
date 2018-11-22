package com.xym.test;

import com.xym.config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName IOCTest_LifeCycle
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 下午2:11
 * @Version 1.0
 **/
public class IOCTest_LifeCycle {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成！");
        context.close();
    }
}