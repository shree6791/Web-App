package com.shree.dao;

import java.util.List;

import com.shree.model.Student;

public interface StudentDAO {

	// --------------------------------------------------------

	public Student findById(int id);
	
	public Student findByName(String firstName);

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
