package com.idream.student;

import jakarta.persistence.*;

@Entity

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	public String email;
	public Long courseId;

	public Student() {
	}

	public Student(Long id, String name, String email, Long courseId) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.courseId = courseId;
	}

}
