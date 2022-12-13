package com.nest.nestDigital_backend.dao;

import com.nest.nestDigital_backend.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    @Query(value = "SELECT `id`, `address`, `designation`, `email`, `emp_code`, `name`, `password`, `salary`, `username` FROM `employee` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<Employee> passwordCheck(@Param("username") String user_name, @Param("password") String password);
}
