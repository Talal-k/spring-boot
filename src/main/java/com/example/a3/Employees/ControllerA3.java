package com.example.a3.Employees;



import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/api")
@Transactional
public class ControllerA3 {

    @Autowired
    public ServiceFirst first;

    @GetMapping("/getAllEmp")
    public List<Emp> getAll(){
     return first.findAll();
    }
    @GetMapping("/getAllManager")
    public List<Manager> getAllManager(){
        return first.findAllManager();
    }
//    @GetMapping("/get/{name}")
//    public Emp getByName(@PathVariable(value = "name") String name){
//        return first.findByName(name);
//    }
//@SneakyThrows
//    @PostMapping(  value= "/insert",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE}  )
//    public Emp insert( @ModelAttribute TestEmp e)  {
//
//Emp p=Emp.builder().name(e.getName()).email(e.getEmail()).salary(e.getSalary()).image(e.getData().getBytes()).build();
//        return  first.save(p);
//    }
    @PostMapping("/Manager/{id}/Emp")
    public Emp insertEmp(@Valid @RequestBody Emp e, @PathVariable int id){
        Manager manager = first.findByIdManager(id);
        e.setManager(manager);
        return first.save(e);
    }
    @PostMapping("/Emp/{id}/User")
    public UserData1 insertUser(@Valid @RequestBody UserData1 user,@PathVariable int id){
        Emp emp = first.findByIdEmp(id);
        user.setEmp(emp);
        return first.save(user);
    }

    @PostMapping("/Manager")
    public Manager insertManager(@Valid @RequestBody Manager manager){
        return first.save(manager);
    }

    @PostMapping("/Emp")
    public Emp insertEmployee(@Valid @RequestBody Emp e){
        return first.save(e);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id){


         first.delete(id);
         return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public Emp update(@PathVariable(value = "id") int id, @Valid@RequestBody Emp newEmployee){
//      Emp e = first.findById(id).orElse(null);
//      if(e != null){
//       e.setName(newEmployee.getName());
//       e.setEmail(newEmployee.getEmail());
//       e.setSalary(newEmployee.getSalary());
//      }
        return first.update(id,newEmployee);
    }

//
//    @SneakyThrows
//    @PostMapping(  value= "/xxxx",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE}  )
//    public Emp insertxxx( @ModelAttribute TestEmp e  )   {
//        Emp p=Emp.builder().name(e.getName()).email(e.getEmail()).salary(e.getSalary()).image(e.getData().getBytes()).build();
/////TestEmpReturn
//p=first.save(p);
//
//        return p;// TestEmpReturn.builder().email(p.getEmail()).name(p.getName()).build();
//    }



}
