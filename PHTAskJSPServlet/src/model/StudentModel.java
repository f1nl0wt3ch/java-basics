package model;

import java.text.*;
import java.util.*;

import entities.*;

public class StudentModel {

	public Student find() {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return new Student("st01", "Name 1", simpleDateFormat.parse("1980-10-20"), "addres 1", "pic1.jpg");
		} catch (Exception e) {
			return null;
		}
	}

	public List<Student> findAll() {
		List<Student> listStudents = new ArrayList<Student>();
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			listStudents.add(new Student("st01", "Name 1", simpleDateFormat.parse("1980-05-20"), "address 1", "pic1.jpg"));
			listStudents.add(new Student("st02", "Name 2", simpleDateFormat.parse("1979-11-13"), "address 2", "pic2.jpg"));
			listStudents.add(new Student("st03", "Name 3", simpleDateFormat.parse("1985-06-25"), "address 3", "pic3.jpg"));
		} catch (Exception e) {
			listStudents = null;
		}
		return listStudents;
	}

}
