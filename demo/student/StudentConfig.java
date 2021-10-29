package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository){
		return args ->{
		Student	student1 = new Student(
					 "mariam", "mariam@yahoo.com", LocalDate.of(1995, Month.JANUARY, 20) );
		Student student2 =	new Student(
							"mary", "mary@yahoo.com", LocalDate.of(1999, Month.JANUARY, 2));
		repository.saveAll(List.of(student1, student2));
		};
		
	}
}
