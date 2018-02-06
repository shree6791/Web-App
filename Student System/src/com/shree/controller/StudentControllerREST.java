package com.shree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.shree.model.Student;
import com.shree.service.StudentService;

@RestController
@RequestMapping("/rest")
public class StudentControllerREST {

	// scan for component dat implement StudentService n inject it as dependency
	@Autowired
	private StudentService studentService;

	// Add Student
	@RequestMapping(value = "/student/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addStudent(@RequestBody Student student, UriComponentsBuilder ucb) {

		System.out.println("start add");
		if (studentService.isStudentExist(student))
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		else {

			studentService.saveStudent(student);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("/student/{id}").buildAndExpand(student.getId()).toUri());

			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}

	}

	// Get Single Student
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {

		Student student = studentService.findById(id);

		if (student == null)
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Student>(student, HttpStatus.OK);

	}

	// Get All Students
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getAllStudents() {

		List<Student> students = studentService.getStudents();

		if (students.isEmpty())
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}

	// Update Student
	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student stud,
			UriComponentsBuilder ucb) {

		Student student = studentService.findById(id);

		if (student == null)
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);

		student.setFirstName(stud.getFirstName());
		student.setLastName(stud.getLastName());
		student.setEmail(stud.getEmail());

		studentService.saveStudent(student);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucb.path("/student/{id}").buildAndExpand(student.getId()).toUri());

		return new ResponseEntity<Student>(headers, HttpStatus.OK);

	}

	// Delete Student
	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) {

		Student student = studentService.findById(id);

		if (student == null)
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);

		studentService.deleteStudentById(id);
		return new ResponseEntity<Student>(HttpStatus.OK);

	}

	// Delete All Students
	@RequestMapping(value = "/student/deleteAll", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteAllStudents() {

		studentService.deleteAllStudents();
		return new ResponseEntity<Student>(HttpStatus.OK);

	}

}
