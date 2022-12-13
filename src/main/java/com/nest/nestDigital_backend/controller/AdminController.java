package com.nest.nestDigital_backend.controller;


import com.nest.nestDigital_backend.dao.AdminDao;
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
    AdminDao adminDao;

    @GetMapping("/")
    public String HomePage(){
        return "Home Page";
    }

    @GetMapping("viewEmployee")
    public List<Employee> ViewAllEmployee(){

        return (List<Employee>) adminDao.findAll();
    }


    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy");
    @PostMapping(path = "/addEmployee", produces = "application/json", consumes = "application/json")
    public Map<String,String> AddEmployee(@RequestBody Employee employee){

        adminDao.save(employee);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("status","success");
        return hashMap;

    }

    @PostMapping(path = "/searchEmployee", produces = "application/json", consumes = "application/json")
    public List<Employee> SearchEmployee(@RequestBody Employee employee){

        String empCode= String.valueOf(employee.getEmpCode());
        System.out.println(empCode);

        return (List<Employee>) adminDao.EmployeeSearch(employee.getEmpCode());
    }
    @PostMapping(path = "/deleteEmployee", produces = "application/json", consumes = "application/json")
    public Map<String,String> DeleteEmployee(@RequestBody Employee employee){

        String empCode= String.valueOf(employee.getEmpCode());
        System.out.println(empCode);
        adminDao.EmployeeDelete(employee.getEmpCode());

        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("status","success");
        return hashMap;
    }

}
