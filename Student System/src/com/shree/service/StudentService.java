package com.shree.service;

import java.util.List;
import com.shree.model.Student;

public interface StudentService {

	// --------------------------------------------------------

	public Student findById(int id);

	// --------------------------------------------------------
	
	public List<Student> getStudents();

	public List<Student> searchStudents(String searchName);

	// --------------------------------------------------------

	public void saveStudent(Student student);

	// --------------------------------------------------------

	public void deleteAllStudents();

	public void deleteStudentById(int id);

	// --------------------------------------------------------

	public boolean isStudentExist(Student Student);

	// --------------------------------------------------------

}
