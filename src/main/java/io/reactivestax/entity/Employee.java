package io.reactivestax.entity;

import io.reactivestax.request.EmployeeRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JoinColumn(name = "department_id")
    @OneToOne
    private Department department;

    public Employee(EmployeeRequest request){
        this.name=request.getName();
    }

}
