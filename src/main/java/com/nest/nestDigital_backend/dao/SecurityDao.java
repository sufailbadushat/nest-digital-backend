package com.nest.nestDigital_backend.dao;

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


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `security` WHERE `emp_code`=:empCode",nativeQuery = true)
    void DeleteSecurity(@Param("empCode") Integer empCode);
}
