package com.nest.nestDigital_backend.dao;

import com.nest.nestDigital_backend.model.Leave;
import org.springframework.data.repository.CrudRepository;

public interface LeaveApplyDao extends CrudRepository<Leave , Integer> {
}
