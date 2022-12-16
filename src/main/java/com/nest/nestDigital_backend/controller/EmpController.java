package com.nest.nestDigital_backend.controller;


import com.nest.nestDigital_backend.dao.AdminDao;
import com.nest.nestDigital_backend.dao.EmpEntryDao;
import com.nest.nestDigital_backend.model.EmpEntry;
import com.nest.nestDigital_backend.model.Employee;
import com.nest.nestDigital_backend.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

public class EmpController {

    @Autowired
    EmpEntryDao empEntryDao;

    @Autowired
    AdminDao adminDao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addEmpLog", produces = "application/json", consumes = "application/json")
    public Map<String,String> AddEmpLog(@RequestBody EmpEntry empEntry){


        empEntryDao.save(empEntry);

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("status","success");
        return hashMap;

    }

}
