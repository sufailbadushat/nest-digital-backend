package com.nest.nestDigital_backend.controller;


import com.nest.nestDigital_backend.dao.EmployeeDao;
import com.nest.nestDigital_backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

public class AdminController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/")
    public String HomePage(){
        return "Home Page";
    }

    @GetMapping("viewEmployee")
    public List<Employee> ViewAllEmployee(){

        return (List<Employee>) employeeDao.findAll();
    }


    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy");
    @PostMapping(path = "/addEmployee", produces = "application/json", consumes = "application/json")
    public Map<String,String> AddEmployee(@RequestBody Employee employee){

        employeeDao.save(employee);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("status","success");
        return hashMap;

    }

    @PostMapping(path = "/searchEmployee", produces = "application/json", consumes = "application/json")
    public List<Employee> SearchEmployee(@RequestBody Employee employee){

        String empCode= String.valueOf(employee.getEmpCode());
        System.out.println(empCode);

        return (List<Employee>) employeeDao.EmployeeSearch(employee.getEmpCode());
    }
    @PostMapping(path = "/deleteEmployee", produces = "application/json", consumes = "application/json")
    public Map<String,String> DeleteEmployee(@RequestBody Employee employee){

        String empCode= String.valueOf(employee.getEmpCode());
        System.out.println(empCode);
        employeeDao.EmployeeDelete(employee.getEmpCode());

        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("status","success");
        return hashMap;
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updateEmployee", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> updateEmployee(@RequestBody Employee emp){
        System.out.println(emp.getId());
        employeeDao.UpdateEmployee(emp.getId(),emp.getAddress(), emp.getDesignation(), emp.getEmail(), emp.getEmpCode(), emp.getName(), emp.getPassword(), emp.getUsername(), emp.getSalary());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("status","success");
        return hashMap;
    }

}
