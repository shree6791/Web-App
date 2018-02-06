package com.shree.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shree.model.Login;
import com.shree.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// inject session factory dependency to StudentDAOImpl Cls
	@Autowired
	private SessionFactory sessionFactory;

	// ------------------------------------------------------------------

	@Override
	public Student findById(int id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Student student = currentSession.get(Student.class, id);

		return student;

	}

	@Override
	@Transactional
	public Student findByName(String firstName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query... sort by last name
		Query<Student> query = currentSession.createQuery("from Student where firstName = :firstName", Student.class);

		query.setParameter("firstName", firstName);

		Student student;

		try {
			// execute query and get result list
			student = query.uniqueResult();
		} catch (NullPointerException npe) {
			return null;
		}

		return student;
	}

	// ------------------------------------------------------------------

	@Override
	public List<Student> getStudents() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query... sort by last name
		Query<Student> query = currentSession.createQuery("from Student order by lastName", Student.class);

		// execute query and get result list
		List<Student> students = query.getResultList();

		// return the results
		return students;

	}

	@Override
	public List<Student> searchStudents(String searchName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = null;

		//
		// only search by name if searchName is not empty
		//
		if (searchName != null && searchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			query = currentSession.createQuery(
					"from Student where lower(firstName) like :theName or lower(lastName) like :theName",
					Student.class);
			query.setParameter("theName", "%" + searchName.toLowerCase() + "%");

		} else {
			// searchName is empty ... so just get all students
			query = currentSession.createQuery("from Student", Student.class);
		}

		// execute query and get result list
		List<Student> students = query.getResultList();

		// return the results
		return students;

	}

	// ------------------------------------------------------------------

	@Override
	public void saveStudent(Student student) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the student ...
		currentSession.saveOrUpdate(student);

	}

	// ------------------------------------------------------------------

	@Override
	public void deleteAllStudents() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete all instances of class in table
		Query query = currentSession.createQuery("delete from Student");

		query.executeUpdate();

	}

	@Override
	public void deleteStudentById(int id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query query = currentSession.createQuery("delete from Student where id=:id");

		query.setParameter("id", id);

		query.executeUpdate();

	}

	// ------------------------------------------------------------------

	@Override
	public boolean isStudentExist(Student student) {
		return findByName(student.getFirstName()) != null;
	}

}
