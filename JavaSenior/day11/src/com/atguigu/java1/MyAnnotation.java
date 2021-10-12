package com.atguigu.java1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author shkstart
 * @create 2019 下午 3:19
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME) //要想让放射获取到当前的注解，就需要加上Runtime
public @interface MyAnnotation {
    String value() default "hello";

}
