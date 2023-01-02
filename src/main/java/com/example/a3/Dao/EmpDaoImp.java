package com.example.a3.Dao;

import com.example.a3.Employees.Emp;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@Setter
public class EmpDaoImp implements EmpDao{

     private SessionFactory sessionFactory;


    public void Insert(Emp e) {
        // open the session
        Session session = sessionFactory.openSession();
        // start the session
        Transaction transaction = session.beginTransaction();
        session.persist(e);
        transaction.commit();
        session.close();
    }

    public void Delete(Emp e) {
     // the same as insert
        // open the session
        Session session = sessionFactory.openSession();
        // start the session
        Transaction transaction = session.beginTransaction();
        session.delete(e);
        transaction.commit();
        session.close();
    }

    public void Update(Emp e) {
        // open the session
        Session session = sessionFactory.openSession();
        // start the session
        Transaction transaction = session.beginTransaction();
        session.update(e);
        transaction.commit();
        session.close();
    }

    public List<Emp> list() {
     Session session = sessionFactory.openSession();
     List<Emp> Employees = session.createQuery("from Emp").list();
     session.close();
     return Employees;
    }

}
