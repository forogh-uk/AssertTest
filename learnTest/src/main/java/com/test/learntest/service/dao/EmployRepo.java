package com.test.learntest.service.dao;

import com.test.learntest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployRepo extends JpaRepository<Employee,Integer> {
}
