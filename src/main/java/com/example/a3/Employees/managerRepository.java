package com.example.a3.Employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface managerRepository extends JpaRepository<Manager,Integer> {
}
