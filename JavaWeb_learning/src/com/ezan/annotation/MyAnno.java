package com.ezan.annotation;

public @interface MyAnno {

    //基本类型
    int value();

    //String
   // String show2();

    //枚举
    Person per();

    //注解
    MyAnno2 anno2();

    //以上类型的数组
    String[] strs();
}
