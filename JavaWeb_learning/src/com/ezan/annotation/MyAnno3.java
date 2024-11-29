package com.ezan.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})      //value可以省略
@Retention(RetentionPolicy.RUNTIME)     //一般都取RUNTIME阶段

public @interface MyAnno3 {
}
