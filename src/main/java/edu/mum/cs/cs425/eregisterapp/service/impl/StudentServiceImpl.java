package edu.mum.cs.cs425.eregisterapp.service.impl;

import edu.mum.cs.cs425.eregisterapp.model.Student;
import edu.mum.cs.cs425.eregisterapp.repository.StudentRepository;
import edu.mum.cs.cs425.eregisterapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;
    @Autowired
   public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student saveStudent(Student student) {
        return null;
    }

    @Override
    public Iterable<Student> getListOfStudent() {
        return repository.findAll(Sort.by("studentName"));
    }

    @Override
    public Page<Student> getListOfStudent(int pageNo) {
        return  repository.findAll(PageRequest.of(pageNo, 2, Sort.by("studentName")));
    }
}
