package com.ezan.annotation;

@MyAnno(value=12,per = Person.P1,anno2=@MyAnno2,strs={"abc","bb"})
@MyAnno3
public class Worker {
    @MyAnno3
    public String name = "abc";
    @MyAnno3
    public void show(){};
}
