package com.xym.config;

import com.xym.bean.Car;
import com.xym.bean.Color;
import com.xym.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName MainConfigOfAutowired
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 下午4:40
 * @Version 1.0
 **/

/**
 * 自动装配：Spring利用依赖注入(DI)，完成对IOC容器中各个组件的依赖关系赋值
 * 1. @Autowired 自动注入
 *      - 默认优先按照类型去容器中找对应的组件:context.getBean(BookDao.class)
 *      - 如果找到多个相同类型的组件，再将属性的名称作为组件的ID去容器中查找:context.getBean("bookDao")
 *      - @Qualifier("bookDao")，指定需要装配的组件的ID
 *      - 自动装配默认一定要将属性赋值好，没有就会报错，可以使用@Autowired(required=false)
 *      - @Primary:让Spring进行自动装配的时候，默认使用首选的Bean,也可以继续使用@Qualifier指定需要装配的Bean的名字
 *
 *      BookService{
 *          @Autowired
 *          BookDao bookDao;
 *      }
 * 2. Spring还支持用@Resource(JSR250)和@Inject(JSR330)
 *      - @Resource: 支持自动装配，默认按名称进行装配，不支持@Primary功能和required=false属性
 *      - @Inject: 需要导入javax.inject包，和Autowired功能一样，但没有required=false属性
 *
 *  @Autowired由Spring定义，其它两个为java规范
 *
 *  原理：由AutowiredAnnotationBeanPostProcessor解析完成自动装配功能
 *
 * 3. @Autowired:构造器，参数，方法，属性
 *      - 标注在方法位置:@Bean+方法参数，参数从容器中获取，默认不写@Autowired效果是一样的，都能自动装配
 *      - 标注在构造器上:如果组件只有一个有参构造，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 *      - 放在参数位置
 *
 * 4. 自定义组件想要使用Spring容器底层的一些组件(ApplicationContext,BeanFactory,...)
 *    自定义组件需实现丝xxxAware:在创建对象的时候，会调用接口规定的方法注入相关组件
 *    把Spring底层一些组件注入到自定义的Bean中
 *    xxxAware 功能使用 xxxProcessor
 *    ApplicationContextAware ==> ApplicationContextAwareProcessor
 */
@Configuration
@ComponentScan({"com.xym.service", "com.xym.dao", "com.xym.controller", "com.xym.bean"})
public class MainConfigOfAutowired {

    @Bean("bookDao2")
    @Primary
    public BookDao bookDao(){

        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

    @Bean
    public Color color(Car car){
        Color color = new Color(car);
        return color;
    }
}