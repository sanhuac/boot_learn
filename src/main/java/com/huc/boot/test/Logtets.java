package com.huc.boot.test;


import com.huc.boot.bean.Book;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/8 14:18
 * @Description: 日志注解
 */
@Slf4j
public class Logtets {

    public static void main(String[] args) {
             test();
        Book book = new Book();
        book.setId(1l);
        System.out.println(book);
        System.out.println(book.getId());
    }

    public static void test(){
        log.info("#########  info  #########");
        log.debug("#########  debug  #########");
        log.error("#########  error  #########");
    }
}
