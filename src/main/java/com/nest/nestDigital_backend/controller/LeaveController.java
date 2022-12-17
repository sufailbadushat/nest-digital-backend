package com.nest.nestDigital_backend.controller;

import com.nest.nestDigital_backend.dao.LeaveApplyDao;
import com.nest.nestDigital_backend.model.Leave;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

@RestController
public class LeaveController {

    @Autowired
    LeaveApplyDao leaveApplyDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLeaves", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addLeaves(@RequestBody Leave leave) {

        HashMap<String, String> map = new HashMap<>();
        System.out.println(leave.toString());
        LocalDate from = LocalDate.parse(String.valueOf(leave.getFrom()));
        LocalDate to = LocalDate.parse(String.valueOf(leave.getTo()));
        long diffInDays = ChronoUnit.DAYS.between(from, to);
        leave.setDays((int) diffInDays+1);
        leaveApplyDao.save(leave);
        map.put("status", "success");
        return map;
    }


}