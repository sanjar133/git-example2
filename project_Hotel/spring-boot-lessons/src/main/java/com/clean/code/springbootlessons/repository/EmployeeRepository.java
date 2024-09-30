package com.clean.code.springbootlessons.repository;

import com.clean.code.springbootlessons.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {



}
