package edu.mum.cs.cs425.eregisterapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="students")
public class Student {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotNull
    private String studentNumber;
    @NotNull
    //@Column(name = "title", nullable = false)
    private String firstName;
    private String middleName;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    @NotNull
    private  boolean isInternational;
    @NotNull
    private String lastName;
    private Float cgpa;

    public Student() {
    }

    public Student(String studentNumber, String firstName,
                   String middleName, String lastName, Float cgpa,
                   LocalDate enrollmentDate, boolean isInternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public boolean getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(boolean isInternational) {
        this.isInternational =  isInternational;
    }

    public void setInternational(boolean international) {
        this.isInternational = international;
    }

    public  String toString() {
        return this.getFirstName() + " " + this.getLastName() + " " + this.getStudentNumber();
    }
}
