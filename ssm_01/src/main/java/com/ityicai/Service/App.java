package com.ityicai.Service;

import com.ityicai.Dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {


        //BookService bookService=new BookServiceImpl();
        //bookService.save();


        //����ioc������ȡ����
        //��������
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao =(BookDao) context.getBean("bookDao");
        bookDao.save();
        //���ӷ��� �ر������ǰ�ػ�����
        context.registerShutdownHook();
        System.out.println();
        System.out.println();
        BookService bookService = (BookService)context.getBean("bookService");
        bookService.save();


    }
}
