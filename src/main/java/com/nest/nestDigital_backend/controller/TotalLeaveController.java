package com.nest.nestDigital_backend.controller;

import com.nest.nestDigital_backend.dao.LeaveTotalDao;
import com.nest.nestDigital_backend.model.Leavetotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
public class TotalLeaveController {

    @Autowired
    LeaveTotalDao leaveTotalDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addTotal",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addTotal(@RequestBody Leavetotal leavetotal){
        HashMap<String, String> map = new HashMap<>();
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear());
        leavetotal.setYear(String.valueOf(localDate.getYear()));
        leaveTotalDao.save(leavetotal);
        map.put("status","success");
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchTotal",consumes = "application/json",produces = "application/json")
    public List<Leavetotal> searchTotal(@RequestBody Leavetotal leavetotal){
        return leaveTotalDao.searchTotalLeavesEmployees(leavetotal.getEmpId());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/editTotal",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> editTotal(@RequestBody Leavetotal leavetotal){
        HashMap<String, String> map = new HashMap<>();
        leavetotal.setYear(String.valueOf(LocalDate.now().getYear()));
        leaveTotalDao.editLeaves( leavetotal.getCasualLeave(), leavetotal.getSickLeave(), leavetotal.getSpecialLeave(), leavetotal.getEmpId(), Integer.valueOf(leavetotal.getYear()));
        map.put("status","success");
        return map;
    }


}
