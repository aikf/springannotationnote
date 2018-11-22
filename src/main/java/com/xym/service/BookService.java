package com.xym.service;

import com.xym.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @ClassName BookService
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 上午9:36
 * @Version 1.0
 **/

@Service
public class BookService {

//    @Autowired(required = false)
//    @Qualifier("bookDao")
//    @Resource 报错
    @Inject
    private BookDao bookDao;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }

    public void print(){
        System.out.println(bookDao);
    }
}