package com.nest.nestDigital_backend.controller;

import com.nest.nestDigital_backend.dao.VisitorDao;
import com.nest.nestDigital_backend.model.Security;
import com.nest.nestDigital_backend.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(value = "*")


public class VisitorController {


    @Autowired
    VisitorDao visitorDao;

    @PostMapping(path = "/addVisitor", produces = "application/json", consumes = "application/json")
    public Map<String, String> AddVisitors(@RequestBody Visitor visitor) {

        visitorDao.save(visitor);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("status", "success");
        return hashMap;

    }

    @GetMapping("viewAllVisitors")
    public List<Visitor> viewAllVisitors(){

        return (List<Visitor>) visitorDao.findAll();
    }
}
