package com.example.a3.Employees;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import org.springframework.web.multipart.MultipartFile;

 import java.util.List;

@Service
public class ServiceFirst {

    @Autowired
    public EmployeeREpository emp;
    @Autowired
    public UserRepository userd;
    @Autowired
    public managerRepository manager;
    public List<Emp> findAll() {
      return    emp.findAll();
    }

    public List<Manager> findAllManager() {
        return    manager.findAll();
    }
    public Emp findByIdEmp(int id) {
      return  emp.findById(id).orElse(null);
    }
    public Manager findByIdManager(int id) {
        return  manager.findById(id).orElse(null);
    }
//    public Emp findByName(String name) {
//        return  emp.findByName(name);
//    }
    public UserData1 findByIdUser(int id) {
        return  userd.findById(id).orElse(null);
    }
        //    public Emp findByName(String name) {
    //        return  emp.findByName(name);
    //    }
    public void delete(int id) {
        emp.deleteById(id);

    }

    public Emp update(int id, Emp newEmployee) {
        emp.findById(id).orElseThrow(()->new RuntimeException());
    return    emp.save(newEmployee);
    }

    public Emp save(Emp e) {
        return emp.save(e);
    }
    public UserData1 save(UserData1 u) {
        return userd.save(u);
    }
    public Manager save(Manager m) {
        return manager.save(m);
    }

}
