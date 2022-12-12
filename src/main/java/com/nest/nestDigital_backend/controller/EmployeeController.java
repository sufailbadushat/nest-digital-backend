package com.nest.nestDigital_backend.controller;


import com.nest.nestDigital_backend.dao.EmployeeDao;
import com.nest.nestDigital_backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/")
    public String HomePage(){
        return "Home Page";
    }

    @PostMapping(path = "/addEmployee", produces = "application/json", consumes = "application/json")
    public Map<String,String> AddEmployee(@RequestBody Employee employee){

        employeeDao.save(employee);

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("status","success");
        return hashMap;

    }
}
