package edu.mum.cs.cs425.eregisterapp.service;

import edu.mum.cs.cs425.eregisterapp.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    public  abstract Student saveStudent(Student student);
    public  abstract Iterable<Student> getListOfStudent();
    public  abstract Page<Student> getAllStudentsPaged(int pageNo);
    public  abstract Student getStudentById(Long studentId);
    public abstract Page<Student> searchStudent(String searchString, int pageNo);
}
