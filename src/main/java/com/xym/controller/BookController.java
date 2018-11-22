package com.xym.controller;

import com.xym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author ak
 * @Date 2018/11/22 上午9:35
 * @Version 1.0
 **/

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}