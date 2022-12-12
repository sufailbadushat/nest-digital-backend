package com.nest.nestDigital_backend.controller;


import com.nest.nestDigital_backend.dao.EmployeeDao;
import com.nest.nestDigital_backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

public class EmployeeController {

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

}
