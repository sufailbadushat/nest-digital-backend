package com.nest.nestDigital_backend.controller;

import com.nest.nestDigital_backend.dao.SecurityDao;
import com.nest.nestDigital_backend.model.Employee;
import com.nest.nestDigital_backend.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

public class SecurityController {

    @Autowired
    SecurityDao securityDao;


    @GetMapping("viewSecurity")
    public List<Security> ViewAllEmployee(){

        return (List<Security>) securityDao.findAll();
    }

    @PostMapping(path = "/addSecurity", produces = "application/json", consumes = "application/json")
    public Map<String,String> AddSecurity(@RequestBody Security security){

        securityDao.save(security);

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("status","success");
        return hashMap;

    }
}
