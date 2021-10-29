package com.example.demo.student;

//import java.time.LocalDate;
//import java.time.Month;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/student")
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService= studentService;
	}
	
	
	@GetMapping
	public List<Student> getStudents(){
		return studentService.getStudent(); 
	}
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		 studentService.addNewStudent(student);
	}
	@DeleteMapping (path = "{studentId}")
	public void deleteAStudent (
			@PathVariable("studentId") Long studentId) {
		studentService.deleteAStudent(studentId);
	}
	
	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable("studentId")Long studentId,
			String name,
			String email) {
		studentService.updateStudent(studentId, name, email);
	}
//	@RequestMapping("/student/{id}")
//	public Student getAStudent(@PathVariable Long id){
//		return studentService.getAStudent(id); 
//	}
//	

}
