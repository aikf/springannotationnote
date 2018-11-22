package com.xym.dao;

import org.springframework.stereotype.Repository;

/**
 * @ClassName BookDao
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 上午9:37
 * @Version 1.0
 **/

@Repository
public class BookDao {
    private String lable = "1";

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}