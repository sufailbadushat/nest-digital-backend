package com.nest.nestDigital_backend.controller;


import com.nest.nestDigital_backend.dao.AdminDao;
import com.nest.nestDigital_backend.dao.EmployeeDao;
import com.nest.nestDigital_backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeeLogin",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> EmployeeLogin(@RequestBody Employee e){
        HashMap<String, String> map = new HashMap<String, String>();
        List<Employee> emp= employeeDao.passwordCheck(e.getUsername(),e.getPassword());
        if (emp.size() != 0) {
            map.put("id",String.valueOf( emp.get(0).getId()));
            map.put("status","success");
            map.put("employeeCode",String.valueOf( emp.get(0).getEmpCode()));
        }else {
            map.put("status","failed");
        }
        return map;
    }

}
