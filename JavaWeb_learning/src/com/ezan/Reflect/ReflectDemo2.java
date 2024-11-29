package com.ezan.Reflect;

import com.ezan.domain.Person;

import java.lang.reflect.Constructor;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        //获取构造方法
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //创建对象    newInstance()
        Object person = constructor.newInstance("张三",23);
        System.out.println(person);

        System.out.println("-----------");
        //使用空参构造方法来创建对象
        Object o = personClass.newInstance();
        System.out.println(o);
    }
}
