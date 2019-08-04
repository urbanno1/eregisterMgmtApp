package edu.mum.cs.cs425.eregisterapp.model;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

}
