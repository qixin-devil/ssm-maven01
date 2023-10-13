package com.ityc.service;

import com.ityc.Pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    List<Student> findAll();

}
