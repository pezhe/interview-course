package ru.pezhe.interview.lesson5;

import ru.pezhe.interview.lesson5.entity.Student;

import java.util.List;

public class Lesson5Application {

	public static void main(String[] args) {

		HibernateDao<Student> studentDao = new HibernateDao<>(SessionFactoryProvider.getSessionFactory(), Student.class);
		//Create students
		for (int i = 0; i < 10; i++) {
			studentDao.save(new Student("Student#" + i));
		}
		System.out.println("List of created students");
		for (Student stud : studentDao.findAll()) {
			System.out.println(stud);
		}

		//Update students (add marks)
		for (Student stud : studentDao.findAll()) {
			stud.setMark(5);
			studentDao.update(stud);
		}

		//Find all students
		System.out.println("\nList of students after update");
		List<Student> studentList = studentDao.findAll();
		for (Student stud : studentList) {
			System.out.println(stud);
		}

		//Find student by ID
		long id = studentList.get(0).getId();
		System.out.println("\nStudent found by ID=" + id + ": " + studentDao.findById(id).get());

		//Delete student by ID
		studentDao.deleteById(id);
		System.out.println("\nList of students after deletion");
		for (Student stud : studentDao.findAll()) {
			System.out.println(stud);
		}

	}

}
