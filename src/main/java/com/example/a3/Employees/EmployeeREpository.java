package com.example.a3.Employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeREpository extends JpaRepository<Emp, Integer> {

public Emp findBName(String name);
@Query(
        " from Emp e where e.firstName=:firstNameParam "


)
    public Emp findByFirstNameContainsIgnoreCaseAndEmailStartWith(String name);

}
