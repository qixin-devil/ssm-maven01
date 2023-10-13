package com.ityicai.Service.Impl;
import com.ityicai.Dao.BookDao;
import com.ityicai.Dao.Impl.UserDaoImpl;
import com.ityicai.Dao.UserDao;
import com.ityicai.Service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {

    private UserDao userDao;
    private BookDao bookDao;
    @Override
    public void save() {
        System.out.println("save a service");
        userDao.save();
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    //利用接口创建生命周期方法
    @Override
    public void destroy() throws Exception {
        System.out.println("结束");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("开始");
    }


}
