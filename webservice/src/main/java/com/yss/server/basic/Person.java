package com.yss.server.basic;

/**
 * @author: duhao
 * @date: 2020/6/20 16:52
 */
public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = name;
        this.age = age;
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
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
