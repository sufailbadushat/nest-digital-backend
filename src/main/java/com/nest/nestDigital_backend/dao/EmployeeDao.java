package com.nest.nestDigital_backend.dao;

import com.nest.nestDigital_backend.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository <Employee,Integer>{



    @Query(value = "SELECT `id`, `address`, `designation`, `email`, `emp_code`, `name`, `password`, `salary`, `username` FROM `employee` WHERE `emp_code`=:empCode", nativeQuery = true)
    List<Employee> EmployeeSearch(@Param("empCode") Integer empCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `employee` WHERE `emp_code`=:empCode", nativeQuery = true)
    void EmployeeDelete(@Param("empCode") Integer empCode);

    @Query(value = "SELECT `id`, `designation`, `email`, `emp_code`, `name`, `password`, `phone`, `username` FROM `employee` WHERE `emp_code`= :empCode", nativeQuery = true)
    List<Employee> UserLoginDetailsById(@Param("empCode") String empCode);


    @Modifying
    @Transactional
    @Query(value = "UPDATE `employee` SET `address`=:address, `designation`=:designation,`email`=:email, `emp_code`=:empCode ,`name`= :name,`password`=:password,`salary`=:salary,`username`=:username WHERE `id`=:id", nativeQuery = true)
    void UpdateEmployee(@Param("id") int id,@Param("address") String address, @Param("designation") String designation,@Param("email") String email,@Param("empCode") int empCode,@Param("name") String name,@Param("password") String password,@Param("username") String username, @Param("salary") int salary);





}



