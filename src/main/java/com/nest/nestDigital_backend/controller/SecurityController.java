package com.nest.nestDigital_backend.controller;

import com.nest.nestDigital_backend.dao.SecurityDao;
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
    private SecurityDao securityDao;


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

    @PostMapping(path = "/searchSecurity", produces = "application/json", consumes = "application/json")
    public List<Security> SearchSecurity(@RequestBody Security security){

        String empCode= String.valueOf(security.getEmpCode());
        System.out.println(empCode);

        return (List<Security>) securityDao.SearchSecurity(security.getEmpCode());
    }

    @PostMapping(path = "/deleteSecurity", produces = "application/json", consumes = "application/json")
    public Map<String,String> DeleteSecurity(@RequestBody Security security){

        String empCode= String.valueOf(security.getEmpCode());
        System.out.println(empCode);
        securityDao.DeleteSecurity(security.getEmpCode());

        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("status","success");
        return hashMap;
    }

    @PostMapping(path = "/securityLogin",  produces = "application/json", consumes = "application/json")
    public Map<String ,String> SecurityLogin(@RequestBody Security security){

        List<Security> result=(List<Security>) securityDao.SecurityLogin(security.getUsername(),security.getPassword());

      HashMap<String,String> hashMap=new HashMap<>();
      if (result.size()!=0){

          hashMap.put("userInfo", String.valueOf(result.get(0).getId()));
          hashMap.put("status","success");

      }
      else {
          hashMap.put("status","Enter valid Credentials");
      }
      return hashMap;
    }

}
