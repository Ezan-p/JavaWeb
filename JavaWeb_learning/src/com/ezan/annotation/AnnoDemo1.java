package com.ezan.annotation;


@SuppressWarnings("aLL")
public class AnnoDemo1 {

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1(){
        //有缺陷
    }

    public void show2(){
        //替代show1的方法
    }

    //@MyAnno         //自定义的注解
    public void main(){
        show1();
    }
}
