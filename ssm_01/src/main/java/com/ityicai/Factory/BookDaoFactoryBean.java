package com.ityicai.Factory;

import com.ityicai.Dao.BookDao;
import com.ityicai.Dao.Impl.BookDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class BookDaoFactoryBean implements FactoryBean<BookDao> {
    @Override
    public BookDao getObject() throws Exception {
        return  new BookDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return BookDao.class;
    }
    // 更改是否单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
