package com.example.ba.myjacksondemo;

/**
 * Created by BA on 2017/11/11 0011.
 *
 * @Function :
 */

public class MyBean {

    private String name;
    private int age;
    private MyBean bean;
    private int cc;

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public MyBean getBean() {
        return bean;
    }

    public void setBean(MyBean bean) {
        this.bean = bean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyBean{"+
                "name="+name+'\''
                +"age="+age+'\''
                +'}';
    }
}
