package com.xym.config;

/**
 * @ClassName MainConfigOfProfile
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 下午8:15
 * @Version 1.0
 **/

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xym.bean.Yellow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile: Spring提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 * 开发环境、测试环境、生产环境
 * @Profile: 指定组件在哪个环境的情况下才能被注册到容器中，不指定任何环境下都能注册这个组件
 * 1. 加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中，默认是default环境
 * 2. 写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3. 没有环境标注的bean在任何环境下都是加载的
 */

@Profile("test")
@Configuration
@PropertySource("classpath:db.properties")
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${jdbc.driver}")
    String driverClass;
    String user;

    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

    @Profile("test")
    @Bean
    public DataSource testDataSource(@Value("${jdbc.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/bookstore");
        return dataSource;
    }

    @Profile("prod")
    @Bean
    public DataSource prodDataSource(@Value("${jdbc.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sys");
        return dataSource;
    }

    @Profile("dev")
    @Bean
    public DataSource devDataSource(@Value("${jdbc.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/demo");
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        user = resolver.resolveStringValue("${jdbc.user}");
    }
}