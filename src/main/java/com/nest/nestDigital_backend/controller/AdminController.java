package com.nest.nestDigital_backend.controller;


import com.nest.nestDigital_backend.dao.AdminDao;
import com.nest.nestDigital_backend.dao.LeaveTotalDao;
import com.nest.nestDigital_backend.model.Employee;
import com.nest.nestDigital_backend.model.Leavetotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

public class AdminController {

    @Autowired
    AdminDao adminDao;
    @Autowired
    LeaveTotalDao leaveTotalDao;

    @GetMapping("/")
    public String HomePage() {
        return "Home Page";
    }

    @GetMapping("viewEmployee")
    public List<Employee> ViewAllEmployee() {

        return (List<Employee>) adminDao.findAll();
    }


    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy");

    @PostMapping(path = "/addEmployee", produces = "application/json", consumes = "application/json")
    public Map<String, String> AddEmployee(@RequestBody Employee employee) {


        HashMap<String, String> hashMap = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();
        adminDao.save(employee);
//        if (emp.size() !=0) {
            List<Employee> result = (List<Employee>) adminDao.UserLoginById(String.valueOf(employee.getEmpCode()));
            Leavetotal leavetotal = new Leavetotal();
            leavetotal.setEmpId(result.get(0).getId());
            leavetotal.setYear(dateTimeFormatter.format(now));
            leavetotal.setCasualLeave(20);
            leavetotal.setSickLeave(7);
            leavetotal.setSpecialLeave(3);
            leaveTotalDao.save(leavetotal);
            hashMap.put("status", "success");
//        }
//        else {
//            hashMap.put("status", "failed");
//        }
        return hashMap;


//        adminDao.save(employee);
//        HashMap<String,String> hashMap = new HashMap<>();
//        hashMap.put("status","success");
//        return hashMap;

    }

    @PostMapping(path = "/searchEmployee", produces = "application/json", consumes = "application/json")
    public List<Employee> SearchEmployee(@RequestBody Employee employee) {

        String empCode = String.valueOf(employee.getEmpCode());
        System.out.println(empCode);


        return (List<Employee>) adminDao.EmployeeSearch(employee.getEmpCode());
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/getEmpById", produces = "application/json", consumes = "application/json")
    public List<Employee> getEmpById(@RequestBody Employee employee) {

        String id = String.valueOf(employee.getId());
        System.out.println(id);


        return (List<Employee>) adminDao.SearchById(employee.getId());
    }

    @PostMapping(path = "/deleteEmployee", produces = "application/json", consumes = "application/json")
    public Map<String, String> DeleteEmployee(@RequestBody Employee employee) {

        String empCode = String.valueOf(employee.getEmpCode());
        System.out.println(empCode);
        adminDao.EmployeeDelete(employee.getEmpCode());

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("status", "success");
        return hashMap;
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updateEmployee", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> updateEmployee(@RequestBody Employee emp){
        System.out.println(emp.getId());
        adminDao.UpdateEmployee(emp.getId(),emp.getAddress(), emp.getDesignation(), emp.getEmail(), emp.getEmpCode(), emp.getName(), emp.getPassword(), emp.getUsername(), emp.getSalary());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("status","success");
        return hashMap;
    }

}
