package com.cesponsibilitychain.demo.dto;

/**
 * @program demo
 * @description: 测策略 + 责任链模式
 * @author: Jin
 * @create: 2021-04-13 17:30
 * @update: 2021-04-13 17:30
 * @intention:
 */
public class User {
    private int age;
    private String name;
    private String sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
