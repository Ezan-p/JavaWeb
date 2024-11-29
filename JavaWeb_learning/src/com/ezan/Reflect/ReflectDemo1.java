package com.ezan.Reflect;

import com.ezan.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        //获取类的class对象
        Class personClass = Person.class;
        //获取所有public修饰的成员变量  getFields()
        Field[] fields = personClass.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
        System.out.println("----------");
        //获取指定成员变量    getField(String a)
        Field a = personClass.getField("a");
        //1.方法一：获取成员变量的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        //2.方法二：设置a的值
        a.set(p,"张三");
        System.out.println(p);

        System.out.println("===========");

        //获取所有的成员变量，不考虑修饰符  getDeclaredFields()
        Field[] declareFields = personClass.getDeclaredFields();
        for (Field declareField : declareFields) {
            System.out.println(declareField);
        }
        //获取指定成员变量   getDeclaredFields(String a)
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查  setAccessible(true)
        d.setAccessible(true);  //暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);
        d.set(p,"lisi");
        System.out.println(p);
    }
}
