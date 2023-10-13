package com.ityicai.Service;

import com.ityicai.Dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {


        //BookService bookService=new BookServiceImpl();
        //bookService.save();


        //利用ioc容器获取连接
        //创建容器
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao =(BookDao) context.getBean("bookDao");
        bookDao.save();
        //钩子方法 关闭虚拟机前关机容器
        context.registerShutdownHook();
        System.out.println();
        System.out.println();
        BookService bookService = (BookService)context.getBean("bookService");
        bookService.save();


    }
}
