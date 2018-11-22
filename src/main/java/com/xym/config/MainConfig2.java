package com.xym.config;

import com.xym.bean.Color;
import com.xym.bean.ColorFactoryBean;
import com.xym.bean.Person;
import com.xym.bean.Red;
import com.xym.condition.MacCondition;
import com.xym.condition.MyImportBeanDefinitionRegistrar;
import com.xym.condition.MyImportSelector;
import com.xym.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @ClassName MainConfig2
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 上午10:35
 * @Version 1.0
 **/
//类中组件统一设置 满足当前条件，这个类中配置的所有bean注册才会生效
@Conditional({MacCondition.class})
@Configuration
//导入组件，ID默认是组件的全类名
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    /**
     * prototype: 多实例的: ioc容器启动时不会创建对象放在容器中，只在每次获取的时候才会调用方法创建对象
     * singleton: 单实例的(默认值)：ioc容器启动会调用方法创建对象放到ioc容器中，以后每次获取直接从容器(map.get())中拿
     * request: 同一次请求创建一个实例
     * session: 同一个session创建一个实例
     *
     * 懒加载：容器启动时不创建对象，在第一次使用(获取)Bean创建对象，并初始化
     */
    @Bean("person")
//    @Scope("prototype")
    @Lazy
    public Person person(){
        System.out.println("给容器添加Person...");
        return new Person("zs", 23);
    }

    /**
     * @Conditional({Condition}): 按照一定的条件进行判断，满足条件给容器中注册Bean
     * 如果系统是Windows，给容器中注册bill
     * 如果系统是Linux，给容器中注册linus
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates", 60);
    }

    @Conditional({MacCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("Linus", 50);
    }

    /**
     * 给容器中注册组件的方式：
     * 1. 包扫描+组件标注注解(@Controller/@Service/@Repository/@Component
     * 2. @Bean[导入第三方包里的组件]
     * 3. @Import[快速给容器中导入一个组件]
     *      - @Import(要导入的组件) 容器会自动注册这个组件，ID默认是全类名
     *      - ImportSelector: 返回需要导入的组件的全类名数组
     *      - ImportBeanDefinitionRegistrar: 手动注册bean到容器中
     * 4. 使用Spring提供的FactoryBean(工厂Bean)
     *      - 默认获取到的是工厂Bean调用getObject创建的对象
     *      - 要获取工厂Bean本身，需要给id前面加一个&
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}