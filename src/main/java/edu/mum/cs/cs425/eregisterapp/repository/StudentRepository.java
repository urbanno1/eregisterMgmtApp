package edu.mum.cs.cs425.eregisterapp.repository;

import edu.mum.cs.cs425.eregisterapp.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    //public abstract Page<Student> findStudentsBy(String searchString, PageRequest request);

    public abstract Page<Student>
    findAllByFirstNameContainingOrLastNameContainingOrStudentNumberContainingOrderByFirstName(String firstName, String lastName, String studentNumber, Pageable pageable);
}
