package com.nest.nestDigital_backend.dao;

import com.nest.nestDigital_backend.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository <Employee,Integer>{



    @Query(value = "SELECT `id`, `address`, `designation`, `email`, `emp_code`, `name`, `password`, `salary`, `username` FROM `employee` WHERE `emp_code`=:empCode", nativeQuery = true)
    List<Employee> EmployeeSearch(@Param("empCode") Integer empCode);
}
