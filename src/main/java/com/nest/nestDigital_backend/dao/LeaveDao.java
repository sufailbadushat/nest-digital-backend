package com.nest.nestDigital_backend.dao;


import com.nest.nestDigital_backend.model.Leavetotal;
import org.springframework.data.repository.CrudRepository;

public interface LeaveDao extends CrudRepository<Leavetotal, Integer> {
}
