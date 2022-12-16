package com.nest.nestDigital_backend.dao;

import com.nest.nestDigital_backend.model.EmpEntry;
import org.springframework.data.repository.CrudRepository;

public interface EmpEntryDao extends CrudRepository<EmpEntry, Integer> {
}
