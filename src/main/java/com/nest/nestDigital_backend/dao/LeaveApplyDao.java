package com.nest.nestDigital_backend.dao;

import com.nest.nestDigital_backend.model.Leave;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveApplyDao extends CrudRepository<Leave , Integer> {



    @Query(value = "SELECT l.`id`, l.`days`, l.`empid`,e.name,e.designation, l.`from`, l.`reason`,l.`status`, l.`to`, l.`type_ofleave` FROM `leaves` l JOIN employee e ON e.employee_code=l.empid ",nativeQuery = true)
    List<Map<String,String>> Leaves();

    @Query(value = "SELECT `id`, `days`, `empid`, `from`, `reason`, `remarks`, `status`, `to`, `type_ofleave` FROM `leaves` WHERE `empid`=:empid",nativeQuery = true)
    List<Leave> searchLeaves(@Param("empid") Integer empid);


}
