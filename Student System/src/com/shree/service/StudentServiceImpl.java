package com.shree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shree.dao.StudentDAO;
import com.shree.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	// need to inject student dao
	@Autowired
	private StudentDAO studentDAO;

	@Override
	@Transactional
	public Student findById(int id) {
		return studentDAO.findById(id);
	}

	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public List<Student> searchStudents(String searchName) {
		return studentDAO.searchStudents(searchName);
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);
	}

	@Override
	@Transactional
	public void deleteStudentById(int id) {
		studentDAO.deleteStudentById(id);
	}

	@Override
	@Transactional
	public void deleteAllStudents() {
		studentDAO.deleteAllStudents();
	}

	@Override
	@Transactional
	public boolean isStudentExist(Student student) {
		return studentDAO.isStudentExist(student);
	}
}
