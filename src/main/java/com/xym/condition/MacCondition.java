package com.xym.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName MacCondition
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 上午11:16
 * @Version 1.0
 **/
public class MacCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        if (property.contains("Mac OS X")) {
            return true;
        }
        return false;
    }
}