package edu.mum.cs.cs425.eregisterapp.service;

import edu.mum.cs.cs425.eregisterapp.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    public  abstract Student saveStudent(Student student);
    public  abstract Iterable<Student> getListOfStudent();
    public  abstract Page<Student> getListOfStudent(int pageNo);
}
