package com.xym.bean;

import org.springframework.stereotype.Component;

/**
 * @ClassName Color
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 上午11:55
 * @Version 1.0
 **/

public class Color {
    private Car car;

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }

    public Color(Car car) {
        this.car = car;
    }

    public Color() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}