package com.xym.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MyImportSelector
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 下午12:08
 * @Version 1.0
 **/
//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {
    //返回值就是要导入到容器中的组件全类名
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //方法不能返回null
        return new String[]{"com.xym.bean.Blue", "com.xym.bean.Yellow"};
    }
}