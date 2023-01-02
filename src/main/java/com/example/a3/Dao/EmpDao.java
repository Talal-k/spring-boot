package com.example.a3.Dao;

import com.example.a3.Employees.Emp;

import java.util.List;

public interface EmpDao {

    public void Insert(Emp e);
    public void Delete(Emp e);
    public void Update(Emp e);
    public List<Emp> list();
}
