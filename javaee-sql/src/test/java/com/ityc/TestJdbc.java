package com.ityc;

import com.alibaba.druid.pool.DruidDataSource;
import com.ityc.Controller.StudentController;
import com.ityc.Pojo.Student;
import com.ityc.config.javaConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(value = javaConfig.class)
public class TestJdbc {
    @Test
    public void Testjava() {
        //创建德伊连接池
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql:///studb");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setPassword("123456");
        druidDataSource.setUsername("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
    }





    @Test
    public void testjdbc1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        //查询语句！！！！！！！！！！！！！！！
        String s1 = "select id,name,gender,age,class as classes from students ; ";
        List<Student> studentList = jdbcTemplate.query(s1, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println(studentList);
    }


    @Test
    public void testjdbc2() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("spring-02.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        //增加语句！！！！！！！！！！！！！！！
        String s2 = "insert into students (id,name,gender,age,class) values(?,?,?,?,?)";
        int update = jdbcTemplate.update(s2, 12,"吕布", "男", "18", "三年二班");
        System.out.println(update);


    }

    @Test
    public void testjdbc3() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("spring-02.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        //修改语句！！！！！！！！！！！！！！！
        String s3 = "update students set name=?,age=? where id=?";
        int update = jdbcTemplate.update(s3,"赵云", "19", 11 );
        System.out.println(update);
    }


    @Test
    public void testjdbc4() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("spring-02.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        //删除语句！！！！！！！！！！！！！！！
        String s4 = "delete from students where id=? ";
        int update = jdbcTemplate.update(s4,1);
        System.out.println(update);
















    }
    @Test
    public void Testjdbc() {
        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(javaConfig.class);

        StudentController studentController = applicationContext.getBean(StudentController.class);
        studentController.findall();

    }

    @Autowired
    private StudentController studentController;

    @Test
    public void Testjdbc2() {
        System.out.println(studentController);

    }

}
