package com.asp.reactive.reactivemongo.repository;

import com.asp.reactive.reactivemongo.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
}
