package com.shree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shree.model.Student;
import com.shree.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	// scan for component dat implement StudentService n inject it as dependency
	@Autowired
	private StudentService studentService;

	@GetMapping("/showStudents")
	public String showStudents(Model model) {

		// get customers from the dao
		List<Student> students = studentService.getStudents();

		// add the customers to the model
		model.addAttribute("students", students);

		return "student-home";
	}

	@GetMapping("/addStudent")
	public String addStudent(Model model) {

		// create model attribute to bind form data
		Student student = new Student();

		model.addAttribute("student", student);

		return "student-form";

	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {

		// save the student using our service
		studentService.saveStudent(student);

		return "redirect:/student/showStudents";
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("studentId") int id, Model model) {

		// get the customer from our service
		Student student = studentService.findById(id);

		// set customer as a model attribute to pre-populate the form
		model.addAttribute("student", student);

		// send over to our form
		return "student-form";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") int id) {

		// delete the customer
		studentService.deleteStudentById(id);

		return "redirect:/student/showStudents";
	}

	@PostMapping("/searchStudent")
	public String searchStudent(@RequestParam("searchName") String searchName, Model model) {

		// search customers from the service
		List<Student> students = studentService.searchStudents(searchName);

		// add the customers to the model
		model.addAttribute("students", students);

		return "student-home";
	}

	@PostMapping("/logoutStudent")
	public String logoutStudent() {
		return "redirect:/login/displayLoginPage";
	}

}
