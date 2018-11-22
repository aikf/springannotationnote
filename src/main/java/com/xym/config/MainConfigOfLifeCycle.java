package com.xym.config;

/**
 * @ClassName MainConfigOfLifeCycle
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 下午2:01
 * @Version 1.0
 **/

import com.xym.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Bean的生命周期：创建---初始化---销毁的过程
 * 容器管理Bean的生命周期
 * 我们可以自定义初始化和销毁方法：容器在Bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 构造(对象创建)
 *  - 单实例：在容器启动时候创建对象
 *  - 多实例：在每次获取的时候才创建对象
 * 初始化：对象创建完成，并赋值好，调用初始化方法
 * 销毁
 *  - 单实例：容器关闭的时候
 *  - 多实例：容器不会管理这个Bean，容器不会调用销毁方法
 *
 *  1. 指定初始化和销毁方法：通过init-method和destroy-method
 *  2. 通过让bean实现InitializingBean(定义初始化逻辑),DisposableBean(定义销毁逻辑)
 *  3. 可以使用JSR250
 *      - @PostConstruct 在Bean创建完成并且属性赋值完成来执行初始化方法
 *      - @PreDestroy 在容器销毁bean之前通知我们进行清理工作
 *  4. BeanPostProcessor[interface]:bean的后置处理器
 *      - postProcessBeforeInitialization:在初始化之前工作
 *      - postProcessAfterInitialization：在初始化之后工作
 * Spring底层对BeanPostProcessor的使用：
 *      Bean赋值，注入其他组件，@AutoWried，生命周期注解功能，@Async，xxxBeanPostProcessor
 */
@Configuration
@ComponentScan("com.xym.bean")
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}