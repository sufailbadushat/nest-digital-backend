package com.nest.nestDigital_backend.dao;

import com.nest.nestDigital_backend.model.LeaveApply;
import com.nest.nestDigital_backend.model.Leavetotal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ViewTotalLeaveDao extends CrudRepository<LeaveApply, Integer> {
     @Query(value = "SELECT * FROM `leavedetails` WHERE `emp_id`=:id",nativeQuery = true)
     List<Leavetotal> searchTotalLeavesEmployees(@Param("id") Integer id);
}
