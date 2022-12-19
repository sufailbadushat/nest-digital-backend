package com.nest.nestDigital_backend.dao;


import com.nest.nestDigital_backend.model.Leavetotal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveTotalDao extends CrudRepository<Leavetotal, Integer> {
   @Query(value = "SELECT * FROM `leavedetails` WHERE `emp_id`=:empId",nativeQuery = true)
   List<Leavetotal> searchTotalLeavesEmployees(@Param("empId") Integer empId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leavedetails` SET `casual_leave`=`casual_leave`-:casualLeave,`sick_leave`=`sick_leave`-:sickLeave ,`special_leave`=`special_leave`-:specialLeave WHERE `emp_id`=:empId AND `year`=:year",nativeQuery = true)
    void editLeaves(@Param("casualLeave") Integer casualLeaves,@Param("sickLeave") Integer sickLeave,@Param("specialLeave") Integer specialLeave,@Param("empId") Integer empId,@Param("year") Integer year);

}
