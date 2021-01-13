package com.employee.employeeExample.repository;

import com.employee.employeeExample.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface playerRepository extends CrudRepository<Player,String> {

//    List<Player> findByRunsMoreThan(int threshHold);

}
