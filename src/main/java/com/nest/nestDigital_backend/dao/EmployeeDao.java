package com.nest.nestDigital_backend.dao;

import com.nest.nestDigital_backend.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository <Employee,Integer>{
}
