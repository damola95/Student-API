package com.example.demo.student;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
	
	private final StudentRepository studentRepo;
	
	@Autowired
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
//	private List<Student> student = Arrays.asList(new Student(
//			1L, "mariam", "mariam@yahoo.com", LocalDate.of(1995, Month.JANUARY, 20),26 ),
//			new Student(
//					2L, "mary", "mary@yahoo.com", LocalDate.of(1999, Month.JANUARY, 2),22 )); 
	
	public List<Student> getStudent(){
		return studentRepo.findAll();
	}
	
	
	public Student getAStudent(Long id) {
		return studentRepo.getById(id);
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail = studentRepo.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("Email Taken");
		}
		else  {
			studentRepo.save(student);
		}
		// TODO Auto-generated method stub
		//System.out.print(student);
	}

	public void deleteAStudent(Long studentId) {
		// TODO Auto-generated method stub
		boolean exist = studentRepo.existsById(studentId);
		
		if(!exist) {
			throw new IllegalStateException("Student does not exist");
		}
		
		studentRepo.deleteById(studentId);
		
	}

	public void updateStudent(Long studentId, String name, String email) {
		// TODO Auto-generated method stub
		Student student = studentRepo.findById(studentId).orElseThrow(()-> new IllegalStateException("Student with Id"));
		
		if (name != null &&  name.length()>0 &&
				!Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		
		if(email != null && name.length()>0 && 
				!Objects.equals(student.getEmail(), email)){
			
			Optional<Student> studentOptional = studentRepo.findStudentByEmail(email);
			if(studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			student.setEmail(email);
		}
	}
	
	

}
