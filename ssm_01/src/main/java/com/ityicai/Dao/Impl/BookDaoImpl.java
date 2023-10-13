package com.ityicai.Dao.Impl;

import com.ityicai.Dao.BookDao;

public class BookDaoImpl implements BookDao {

    private int number;
    private String mysql;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setMysql(String mysql) {
        this.mysql = mysql;
    }


    @Override
    public void save() {
        System.out.println("save a book and "+"  "+number+"  "+mysql);
    }

    public  void init(){
        System.out.println("init");
    }

    public  void destory(){
        System.out.println("destory");
    }
}
