package com.nest.nestDigital_backend.dao;

import com.nest.nestDigital_backend.model.Security;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security, Integer> {

    @Query(value = "SELECT * FROM `security` WHERE `emp_code`=:empCode",nativeQuery = true)
    List<Security> SearchSecurity(@Param("empCode") Integer empCode);
}
