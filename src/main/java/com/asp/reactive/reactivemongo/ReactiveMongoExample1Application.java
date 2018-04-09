package com.asp.reactive.reactivemongo;

import com.asp.reactive.reactivemongo.model.Employee;
import com.asp.reactive.reactivemongo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveMongoExample1Application {

	@Bean
	CommandLineRunner employees(EmployeeRepository  employeeRepository) {

		return args -> {
			employeeRepository
					.deleteAll()
			.subscribe(null, null, () -> {

				Stream.of(new Employee(UUID.randomUUID().toString(),
						"Bill", 55000L),new Employee(UUID.randomUUID().toString(),
						"Warren", 66000L),new Employee(UUID.randomUUID().toString(),
						"Steve", 20000L),new Employee(UUID.randomUUID().toString(),
						"Chris", 53000L)
						)
						.forEach(employee -> {
				employeeRepository
						.save(employee)
						.subscribe(System.out::println);

						});

			})
			;
		};

	}


	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoExample1Application.class, args);
	}
}
