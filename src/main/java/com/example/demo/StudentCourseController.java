package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {
	
	private StudentRepository studentRepository;
	
	private CourseRepository courseRepository;
	
	public StudentCourseController(StudentRepository studentRepository , CourseRepository courseRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
	
	
	@PostMapping
	public Student saveStudentWithCourse(@RequestBody Student student) {
		
		return studentRepository.save(student);
	}

	@GetMapping
	public List<Student> findAllStudents(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/{studentID}")
	public Student findStudent(@PathVariable Long studentID) {
		return studentRepository.findById(studentID).orElse(null);
	}
	
	@GetMapping("/find/{name}")
	public List<Student> findStudentsContainingByName(@PathVariable String name){
		
		return studentRepository.findByNameContaining(name);
	}
	
	@GetMapping("/search/{price}")
	public List<Course> findCourseLessThanPrice(@PathVariable double price){
		return courseRepository.findByFeeLessThan(price);
	}
}



























