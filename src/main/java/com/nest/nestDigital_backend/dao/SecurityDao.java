package com.nest.nestDigital_backend.dao;

import com.nest.nestDigital_backend.model.Employee;
import com.nest.nestDigital_backend.model.Security;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security, Integer> {

    @Query(value = "SELECT * FROM `security` WHERE `emp_code`=:empCode",nativeQuery = true)
    List<Security> SearchSecurity(@Param("empCode") Integer empCode);

    @Query(value = "SELECT `id`, `emp_code`, `name`, `password`, `phone`, `username` FROM `security` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<Security> SecurityLogin(@Param("username") String username, @Param("password") String password);


    @Query(value = "SELECT * FROM `security` WHERE `id`=:id",nativeQuery = true)
    List<Security> SearchSecurityById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `security` WHERE `emp_code`=:empCode",nativeQuery = true)
    void DeleteSecurity(@Param("empCode") Integer empCode);
}
