package com.xym.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName Person
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 上午9:15
 * @Version 1.0
 **/
public class Person {

    /**
     * 使用@Value赋值：
     * 1. 基本数值 2. 可以写SpEL:#{} 3. 可以写${}取出配置文件中的值(在运行环境变量里的值)
     */
    @Value("张三")
    private String name;
    @Value("#{20-2}")
    private int age;
    @Value("${person.nickName}")
    private String nickName;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
}