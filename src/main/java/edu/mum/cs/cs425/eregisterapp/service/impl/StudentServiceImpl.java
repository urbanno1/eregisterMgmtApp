package edu.mum.cs.cs425.eregisterapp.service.impl;

import edu.mum.cs.cs425.eregisterapp.model.Student;
import edu.mum.cs.cs425.eregisterapp.repository.StudentRepository;
import edu.mum.cs.cs425.eregisterapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Iterable<Student> getListOfStudent() {
        return repository.findAll(Sort.by("firstName"));
    }

    @Override
    public Page<Student> getAllStudentsPaged(int pageNo) {
        return  repository.findAll(PageRequest.of(pageNo, 2, Sort.by("firstName")));
    }
}
